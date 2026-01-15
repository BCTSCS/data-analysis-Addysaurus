import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArticleAnalyzer {

    private ArrayList<String> stopWords; //load from FileOperators
    private ArrayList<Article> articles; //load from FileOperators json 

    public ArticleAnalyzer() {
        stopWords = FileOperator.getStringList("stopwords.txt");
        articles = new ArrayList<>();
        System.out.println("Articles count: " + articles.size());
        System.out.println("Stopword count: " + stopWords.size());
    };

    public void addStopWord(String word) {};

    public void addArticle(Article article) {};

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
        return null;
    }; //remove stop words from Description

    public static void main(String[] args) {
        ArticleAnalyzer analyzer = new ArticleAnalyzer();
        ArrayList<String> lines = FileOperator.getStringList("data.txt");
        String line = lines.get(0);
        Article a = analyzer.parseJson(line);
        System.out.println(a);
    }

}
