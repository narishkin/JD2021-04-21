package by.it.zhurauleu.jd01_06;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    private static final String WORD_PATTERN = "[а-яА-ЯёЁ]+";

    public static void main(String[] args) {
        long startTime;
        long finishTime;
        startTime = System.nanoTime();
        String slowLongText = slow(Poem.TEXT);
        finishTime = System.nanoTime();
        System.out.printf("slowTime: %10g ms \n",(finishTime-startTime)/1000000.0);
        startTime = System.nanoTime();
        System.out.println(slowLongText);
        String fastLongText = fast(Poem.TEXT);
        finishTime = System.nanoTime();
        System.out.printf("fastTime: %10g ms \n",(finishTime-startTime)/1000000.0);
        System.out.println(fastLongText);

    }

    private static String slow(String inputText) {
        StringBuilder text = new StringBuilder(inputText);
        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Random random1 = new Random(23);
        String longtext = "";
        while (longtext.length() < 100000) {
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                if (random1.nextBoolean()) {
                    longtext = longtext.concat(matcher.group() + " ");
                }
            }
        }
        return longtext;
    }

    private static String fast(String inputText) {
        StringBuilder text = new StringBuilder(inputText);
        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Random random1 = new Random(23);
        StringBuilder longtext = new StringBuilder();
        while (longtext.length() < 100000) {
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                if (random1.nextBoolean()) {
                    longtext.append(matcher.group());
                    longtext.append(" ");
                }
            }
        }
        return longtext.toString();
    }
}
