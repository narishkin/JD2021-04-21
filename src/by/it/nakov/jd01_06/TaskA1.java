package by.it.nakov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {

    public static final String WORD_PATTERN = "[а-яёА-ЯЁ]{4,}";
    public static final char REPLACE_CHAR = '#';

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.TEXT);
        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int position = matcher.start();
            text.setCharAt(position + 3, REPLACE_CHAR);
            int wordLenght = matcher.end() - matcher.start();
            if (wordLenght >= 7) {
                text.setCharAt(position + 6, REPLACE_CHAR);
            }
        }
        System.out.println(text);
    }
}
