import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReviewCollector {
    private ArrayList<ProductReview> reviewList;
    private ArrayList<String> productList;

    public ReviewCollector() {
        reviewList = new ArrayList<>();
        productList = new ArrayList<>();
    }

    public void addReview(ProductReview prodReview) {
        reviewList.add(prodReview);
        if (!productList.contains(prodReview.getName())) {
            productList.add(prodReview.getName());
        }
        System.out.println("Number of products: " + productList.size());
    }

    public int getNumGoodReviews(String prodName) {
        int goodCount = 0;

        for (ProductReview p : reviewList) {
            if (p.getName().equals(prodName)) {
                String review = p.getReview();
                String[] words = review.split(" ");
                double total = 0;
                for (String word : words) {
                    total += getSentiments(word);
                }
                if (total > 1) {
                    goodCount += 1;
                }
            }
        }
        return goodCount;
    }

    public double getSentiments(String wordSearch) {
       // Read lines from sentiments.txt
        ArrayList<String> lines = FileOperator.getStringList("sentiments.txt");

        // Regex pattern to match word,decimal pairs
        Pattern pattern = Pattern.compile("([a-zA-Z0-9]+),(-?\\d+\\.\\d+)");

        // Process each line
        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String word = matcher.group(1); // Extract the word
                Double value = Double.parseDouble(matcher.group(2)); // Extract the value
                if(wordSearch.equals(word)){
                    System.out.println(word + "   ----  " + value);
                    return value;
                }
            }
         
        }
        return 0.0;
   }
}