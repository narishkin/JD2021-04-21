package by.it.nakov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskA2 {
    public static final String WORD_PATTERN = "[а-яёА-ЯЁ]+";

    private static String[] arrString = {};
    private static int[] arrInt = {};

    private static int pos(String word) {
        for (int i = 0; i < arrString.length; i++) {
            if (arrString[i].equals(word)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Matcher matcher = pattern.matcher(Poem.TEXT);
        while (matcher.find()) {
            String word = matcher.group();
            int position = pos(word);
            if (position >= 0) {
                arrInt[position]++;
            } else {
                int last = arrString.length;
                arrString = Arrays.copyOf(arrString, last + 1);
                arrString[last] = word;
                arrInt = Arrays.copyOf(arrInt, last + 1);
                arrInt[last] = 1;
            }
        }
        for (int i = 0; i < arrString.length; i++) {
            System.out.println(arrString[i] + "=" + arrInt[i]);
        }
    }
}
