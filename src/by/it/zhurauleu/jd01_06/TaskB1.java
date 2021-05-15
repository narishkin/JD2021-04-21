package by.it.zhurauleu.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static final String WORD_PATTERN = "[а-яёА-ЯЁ]+";
    private static final String VOWELS = "аяуюэеыиоёАЯУЮЭЕЫИОЁ";

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Matcher matcher = pattern.matcher(Poem.TEXT);
        while (matcher.find()) {
            String word = matcher.group();
            if (checkWord(word)) {
                System.out.println(word);
            }
        }
    }

    private static boolean checkWord(String word) {
        boolean checkFirstLetter = VOWELS.indexOf(word.charAt(0)) < 0;
        boolean checkLastLetter = VOWELS.indexOf(word.charAt(word.length() - 1)) >= 0;
        return checkFirstLetter && checkLastLetter;
    }

}














