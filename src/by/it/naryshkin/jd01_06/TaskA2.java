package by.it.naryshkin.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = new String[0];
    private static int[] amount = {};


    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m1 = p1.matcher(Poem.text);
        while (m1.find()) {
            String word = m1.group();
            int p = position(word);
            if (p >= 0) {
                amount[p]++;
            } else {
                words = Arrays.copyOf(words, words.length + 1);
                amount = Arrays.copyOf(amount, amount.length + 1);
                words[words.length - 1] = word;
                amount[amount.length - 1] = 1;
            }
        }

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i] + "=" + amount[i]);
        }

    }


    private static int position(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }
}
