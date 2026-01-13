import java.util.regex.*;
import java.util.ArrayList;

public class Regex {
    public static void main(String[] args) {
        String re_phone_number = "\\(?[0-9]{3}\\)?\\-?[0-9]{3}\\-?[0-9]{4}";
        String re_email = "[a-zA-Z0-9]{0,}\\@[a-zA-Z0-9]{0,}\\.[a-zA-Z0-9]{0,}";
        String re_zip_code = "[0-9]{5}\\-?([0-9]{4})?";
        String re_ssn = "[0-9]{3}[-\\s]?[0-9]{2}[-\\s]?[0-9]{4}";
        String phone = "123-456-7890";
        String email = "test@gmail.com";
        String zip_code = "07632";
        String ssn = "123 45-6789";
        boolean result_phone = phone.matches(re_phone_number);
        boolean result_email = email.matches(re_email);
        boolean result_zip_code = zip_code.matches(re_zip_code);
        boolean result_ssn = ssn.matches(re_ssn);
        System.out.println(result_phone);
        System.out.println(result_email);
        System.out.println(result_zip_code);
        System.out.println(result_ssn);

        String sample_text = "I am extreml Uhhhhhh 0.84782 I Iz";
        Pattern pattern_capital = Pattern.compile("[A-Z][a-zA-Z]{0,}");
        Matcher matcher_capital = pattern_capital.matcher(sample_text);
        ArrayList<String> matched_substrings_capital = new ArrayList<>();
        while (matcher_capital.find()) {
            matched_substrings_capital.add(matcher_capital.group());
        }
        System.out.println(matched_substrings_capital);
        Pattern pattern_number = Pattern.compile("[0-9]{0,}\\.?[0-9]{0,}");
        Matcher matcher_number = pattern_number.matcher(sample_text);
        ArrayList<String> matched_substrings_number = new ArrayList<>();
        while (matcher_number.find()) {
            matched_substrings_number.add(matcher_number.group());
        }
        System.out.println(matched_substrings_number);
        Pattern pattern_words_lengths = Pattern.compile("[a-zA-Z]{7}");
        //You can change that number to whatever you want, I just set it to 7 arbitrarily
        Matcher matcher_words_lengths = pattern_words_lengths.matcher(sample_text);
        ArrayList<String> matched_substrings_words_lengths = new ArrayList<>();
        while (matcher_words_lengths.find()) {
            matched_substrings_words_lengths.add(matcher_words_lengths.group());
        }
        System.out.println(matched_substrings_words_lengths);
        Pattern pattern_repeated = Pattern.compile("\\b(\\w+)\\b(?:\\W+\\1\\b)+");
        //You can change that number to whatever you want, I just set it to 7 arbitrarily
        Matcher matcher_repeated = pattern_repeated.matcher(sample_text);
        ArrayList<String> matched_substrings_repeated = new ArrayList<>();
        while (matcher_repeated.find()) {
            matched_substrings_repeated.add(matcher_repeated.group());
        }
        System.out.println(matched_substrings_repeated);
        //READING POSTS
        // ArrayList<String> posts = FileOperator.getStringList("posts.txt")
        // for (String post : posts) {
        //     String result post.
    }
}