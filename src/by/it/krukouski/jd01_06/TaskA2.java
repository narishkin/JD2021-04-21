package by.it.krukouski.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    public static final String WORD_PATTERN = "[а-яёА-ЯЁ]+";
    public static String[] words = new String[0];
    public static int[] count = new int[0];

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Matcher matcher = pattern.matcher(Poem.TEXT);
        while (matcher.find()) {
            String word = matcher.group();
            processWord(word);

        }
        printResult();
    }

    public static void processWord(String word) {
        for (int i = 0, wordsLength= words.length; i < wordsLength; i++) {
            String currentWord = words[i];
            if (currentWord.equals(word)) {
                count[i]++;
                return;
            }

        }
        words = Arrays.copyOf(words, words.length + 1);
        words[words.length - 1] = word;
        count = Arrays.copyOf(count, count.length + 1);
        count[count.length - 1] = 1;
    }

    public static void printResult() {
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d\n", words[i], count[i]);
        }
    }
}
