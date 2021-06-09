package by.it.mogonov.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    private static String STR = "[.,;:!?\\-/]";

    public static void main(String[] args) {

        Map<String, Integer> wordCounts = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        for (; ; ) {

            String word = sc.next().replaceAll(STR, "");
            if (word.equals("end")) {
                break;
            }

            if (!wordCounts.containsKey(word))
                wordCounts.put(word, 1);
            else
                wordCounts.put(word, wordCounts.get(word) + 1);

            System.out.println(word + "=" + wordCounts.get(word));

        }

    }
}
