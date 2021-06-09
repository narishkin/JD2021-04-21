package by.it.naryshkin.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> vocStat = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String word;
        while (!(word = sc.next()).equals("end")) {
            word = word.replaceAll("[.,:;]", "");
            if (!vocStat.containsKey(word)) {
                vocStat.put(word, 1);
            } else {
                vocStat.put(word, vocStat.get(word) + 1);
            }
        }
        for (Map.Entry<String, Integer> pair : vocStat.entrySet()) {
            System.out.println(pair.getKey() + "=" + pair.getValue());
        }
    }
}
