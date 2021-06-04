package by.it.mogonov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB1 {

    public static final String WORD_PATTERN = "[а-яёА-ЯЁ]+";
    private static final String LETTERS = "уеыаоэяиюёУЕЫАОЭЯИЮЁ";

    public static void main(String[] args) {


        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            if (checkWord(word)) {
                System.out.println(word);
            }
        }
    }

    private static boolean checkWord(String word) {
        boolean first = LETTERS.indexOf(word.charAt(0)) <= 0;
        boolean last = LETTERS.indexOf(word.charAt(word.length() - 1)) >=0;
        return first && last;
    }
}