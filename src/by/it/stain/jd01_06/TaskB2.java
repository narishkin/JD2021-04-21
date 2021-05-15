package by.it.stain.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static final String WORD_PATTERN = "[а-яёА-ЯЁ]{1,}";
    public static final char REPLACE_CHAR = ' ';
    public static final String CHAR_PATTERN = "[.]";

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.TEXT);
        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Matcher matcher = pattern.matcher(text);
        matcher.replaceAll("[.]");

        System.out.println(text);


        while (matcher.find()){


            text.setCharAt(matcher.end(), REPLACE_CHAR);


        }
        System.out.println(text);


    }
}
