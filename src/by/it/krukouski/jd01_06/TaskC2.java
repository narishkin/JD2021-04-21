package by.it.krukouski.jd01_06;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    public static final String WITHOUT = "[\n,.\\-!;:?]+";
    public static final String WORD_PATTERN = "[а-яёА-ЯЁ]+";
    public static String[] ARRAY_WORDS = new String[0];

    public static void main(String[] args) {
        String formatText = Poem.TEXT.replaceAll(WITHOUT, " ");
        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Matcher matcher = pattern.matcher(formatText);
        while (matcher.find()) {
            String word = matcher.group();
            wordToArray(word);
        }
        long startTimeSlow = System.nanoTime();
        String stringSlow = "";
        System.out.println(slow(stringSlow));
        long finishTimeSlow = System.nanoTime();
        long timeSlow = finishTimeSlow - startTimeSlow;

        long startTimeFast = System.nanoTime();
        String stringFast = "";
        System.out.println(fast(stringFast));
        long finishTimeFast = System.nanoTime();
        long timeFast = finishTimeFast - startTimeFast;
        System.out.println("Time in milliseconds Slow method " + timeSlow / 100000);
        System.out.println("Time in milliseconds Fast method " + timeFast / 100000);
    }

    private static String slow(String text) {
        while (text.length() < 100001) {
            Random random = new Random(1);
            for (int i = 0; i <= ARRAY_WORDS.length; i++) {
                text = text.concat(ARRAY_WORDS[random.nextInt(ARRAY_WORDS.length)]).concat(" ");
            }
        }
        return text;
    }

    private static String fast(String text) {
        StringBuilder resultString = new StringBuilder(text);
        while (resultString.length() < 100001) {
            Random random = new Random(1);
            for (int i = 0; i <= ARRAY_WORDS.length; i++) {
                resultString.append(ARRAY_WORDS[random.nextInt(ARRAY_WORDS.length)]).append(" ");
            }
        }
        return resultString.toString();
    }


    private static void wordToArray(String word) {
        ARRAY_WORDS = Arrays.copyOf(ARRAY_WORDS, ARRAY_WORDS.length + 1);
        ARRAY_WORDS[ARRAY_WORDS.length - 1] = word;
    }


}
