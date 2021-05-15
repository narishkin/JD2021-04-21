package by.it.sapazhkou.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    private static String[] arrayWord = new String[0];
    private static int[] arrayCountWord = new int[0];

    private static int pos(String word) {
        for (int i = 0; i < arrayWord.length; i++) {
            if (arrayWord[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            int position = pos(word);
            if (position >= 0) {
                arrayCountWord[position]++;
            } else {
                int last = arrayWord.length;
                arrayWord = Arrays.copyOf(arrayWord, last + 1);
                arrayWord[last] = word;
                arrayCountWord = Arrays.copyOf(arrayCountWord, last + 1);
                arrayCountWord[last] = 1;
            }
        }
        for (int i = 0; i < arrayWord.length ; i++) {
            System.out.println(arrayWord[i]+ "="+ arrayCountWord[i]);
        }
    }
}
