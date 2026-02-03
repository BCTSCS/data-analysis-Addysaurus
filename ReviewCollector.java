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
        for (ProductReview p : reviewList) {
            String r = p.getReview();
            String[] words = r.split(" ");
            double total = 0;
            for (String word : words) {
                
            }
        }
    }

    public void getSentiments(String word) {
        // Regex pattern to match word,decimal pairs
        Pattern pattern = Pattern.compile("([a-zA-Z0-9]+),(-?\\d+\\.\\d+)");

        // Process each line
        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String word = matcher.group(1); // Extract the word
                Double value = Double.parseDouble(matcher.group(2)); // Extract the value

                // Add to instance variables
                words.add(word);
                values.add(value);

                // Print the result
                System.out.println(word + "   ----  " + value);
   
            }
        }
    }

    public static void main(String[] args) {
        ReviewCollector reviewCollector= new ReviewCollector();
        ArrayList<String> lines = FileOperator.getStringList("product.txt");
        Pattern productPattern = Pattern.compile("Product:\\s*(.+)");
        Pattern reviewPattern = Pattern.compile("Review:\\s*(.+)");

        String productName = null;
        String review =null;
        for (String line : lines) {
            Matcher productMatcher = productPattern.matcher(line);
            Matcher reviewMatcher = reviewPattern.matcher(line);

            if (productMatcher.find()) {
                productName = productMatcher.group(1);
            } else if (reviewMatcher.find()) {
                review = reviewMatcher.group(1);
            }
            
            if (productName!=null &review!=null ){
                ProductReview product = new ProductReview(productName, review);
                reviewCollector.addReview(product);
                System.out.println(product);
            }
        }
    }
}