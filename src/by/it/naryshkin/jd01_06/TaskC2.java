package by.it.naryshkin.jd01_06;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    private static String[] voc = new String[0];

    static String s = "";
    static String f = "";


    public static void main(String[] args) {

        long s1 = System.nanoTime();
        s = slow(Poem.text);
        long s2 = System.nanoTime();
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("Slow Method working time: " + (s2-s1));
        long s3 = System.nanoTime();
        f = fast(Poem.text);
        long s4 = System.nanoTime();
        System.out.println(f);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println("Fast Method working time: " + (s4-s3));

    }

    private static int exist(String word) {
        for (int i = 0; i < voc.length; i++) {
            if (voc[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }

    private static String slow(String text) {
        String t = "";
        Random rnd = new Random(10);
        Pattern p1 = Pattern.compile("[А-Яа-яёЁ]+");
        Matcher m1 = p1.matcher(text);
        while (m1.find()) {
            String word = m1.group();
            int p = exist(word);
            if (p >= 0) {
            } else {
                voc = Arrays.copyOf(voc, voc.length + 1);
                voc[voc.length - 1] = word;
            }
        }
        for (int i = 0; i < 100000; i++) {
            int number =  (rnd.nextInt(125));
            t = t + voc[number] + " ";
        }
        return t;
    }
    private static String fast(String text) {
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random(10);
        String t = "";
        Pattern p1 = Pattern.compile("[А-Яа-яёЁ]+");
        Matcher m1 = p1.matcher(text);
        while (m1.find()) {
            String word = m1.group();
            int p = exist(word);
            if (p >= 0) {
            } else {
                voc = Arrays.copyOf(voc, voc.length + 1);
                voc[voc.length - 1] = word;
            }
        }
        for (int i = 0; i < 100000; i++) {
            int number =  (rnd.nextInt(125));
            sb.append(voc[number] + " ");
        }
        return sb.toString();
    }
}
