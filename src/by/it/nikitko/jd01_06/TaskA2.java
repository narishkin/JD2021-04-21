package by.it.nikitko.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    public static final String WORD_PATTERN = "[а-яёА-ЯЁ]+";
    private static String[] words = new String[0];
    private static int[] counts = new int[0];

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Matcher matcher = pattern.matcher(Poem.TEXT);
        while (matcher.find()) {
            String word = matcher.group();
            processOneWord(word);
        }
        printResult();
    }

    private static void processOneWord(String word) {
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            if (currentWord.equals(word)) {
                counts[i]++;
                return;
            }
        }
        words = Arrays.copyOf(words, words.length + 1);
        words[words.length - 1] = word;
        counts = Arrays.copyOf(counts, counts.length + 1);
        counts[counts.length - 1] = 1;
    }

    private static void printResult() {
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d\n",words[i],counts[i]);
        }
    }
}
