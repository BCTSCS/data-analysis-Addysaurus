import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArticleAnalyzer {

    private ArrayList<String> stopWords; //load from FileOperators
    private ArrayList<Article> articles; //load from FileOperators json 
    private static ArrayList<String> words;
    private static ArrayList<Double> sentiments;

    public ArticleAnalyzer() {
        stopWords = FileOperator.getStringList("stopwords.txt");
        articles = new ArrayList<>();
        System.out.println("Articles count: " + articles.size());
        System.out.println("Stopword count: " + stopWords.size());
    };

    public void addStopWord(String word) {};

    public void addArticle(Article article) {
        articles.add(article);
    };

    public Article parseJson(String jsonLine) {
        Article result;
        Pattern l = Pattern.compile("\"link\":\\s*\"([^\"]+)\"");
        Pattern h = Pattern.compile("\"headline\":\\s*\"([^\"]+)\"");
        Pattern c = Pattern.compile("\"category\":\\s*\"([^\"]+)\"");
        Pattern d = Pattern.compile("\"short_description\":\\s*\"([^\"]+)\"");
        Pattern a = Pattern.compile("\"authors\":\\s*\"([^\"]+)\"");
        Pattern t = Pattern.compile("\"date\":\\s*\"([^\"]+)\"");

        Matcher lm = l.matcher(jsonLine); //parameter - line of text
        String lt = lm.find() ? lm.group(1) : ""; //extract the destined part

        Matcher hm = h.matcher(jsonLine); //parameter - line of text
        String ht = hm.find() ? hm.group(1) : ""; //extract the destined part

        Matcher cm = c.matcher(jsonLine); //parameter - line of text
        String ct = cm.find() ? cm.group(1) : ""; //extract the destined part

        Matcher dm = d.matcher(jsonLine); //parameter - line of text
        String dt = dm.find() ? dm.group(1) : ""; //extract the destined part

        Matcher am = a.matcher(jsonLine); //parameter - line of text
        String at = am.find() ? am.group(1) : ""; //extract the destined part

        Matcher tm = t.matcher(jsonLine); //parameter - line of text
        String tt = tm.find() ? tm.group(1) : ""; //extract the destined part

        result = new Article(lt, ht, ct, dt, at, tt);
        return result;
    }; //use Pattern and matcher to create 

    public String removeStopWords(String text) {
        for (String word : stopWords) {
            text = text.replaceAll("\\b" + word + "\\b", "");
            text = text.replaceAll("  ", " ");
        }
        return text;
    };

    public static void main(String[] args) {
        // ArticleAnalyzer analyzer = new ArticleAnalyzer();
        // ArrayList<String> lines = FileOperator.getStringList("data.txt");
        // for (String line : lines) {
        //     Article a = analyzer.parseJson(line);
        //     String clean = analyzer.removeStopWords(a.getDescription());
        //     a.setDescription(clean);
        //     analyzer.addArticle(a);
        //     System.out.println(a.getDescription());
        // }
        ArrayList<String> lines = FileOperator.getStringList("sentiments.txt");
        words = new ArrayList<>();
        sentiments = new ArrayList<>();
        for (String line : lines) {
            Pattern w = Pattern.compile("([A-Za-z0-9]+)");  //r write regex to extract the word before, and value after
            Pattern s = Pattern.compile("(-?\\d+\\.?\\d*)");  //r write regex to extract the word before, and value after
            Matcher wm = w.matcher(line); //parameter - line of text
            Matcher sm = s.matcher(line); //parameter - line of text
            boolean wfound = wm.find(); 
            boolean sfound = sm.find(); 
            String word = wfound ? wm.group(1) : ""; 
            Double value = sfound ? Double.parseDouble(sm.group(1)) : 0.00;
            words.add(word);
            sentiments.add(value);
            System.out.println(word + "   ----  " + value);
        }
    }
}
