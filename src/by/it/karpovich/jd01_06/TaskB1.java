package by.it.karpovich.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static final String WORD_PATTERN = "[а-яёА-ЯЁ]+";
    private static final String VOTES = "aыэуояиеюёАЫЭУОЯИЕЮЁ";
    public static void main(String[] args){
        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            if (VOTES.indexOf(word.charAt(0)) < 0 && VOTES.indexOf(word.charAt(word.length() - 1)) >= 0){
                System.out.println(word);
            }
        }
    }
}
