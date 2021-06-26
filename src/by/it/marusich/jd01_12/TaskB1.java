package by.it.marusich.jd01_12;

import java.util.HashMap;
import java.util.Scanner;

public class TaskB1 {
    private static final String WITHOUT = "[,.?!:;]*";

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        for (; ; ) {
            String wordKey = sc.next().replaceAll(WITHOUT, "");
            if (wordKey.equals("end")) {
                break;
            }
            if (map.containsKey(wordKey)) {
                Integer count = map.get(wordKey);
                count += 1;
                map.put(wordKey, count);
            } else {
                map.put(wordKey, 1);
            }
        }
        System.out.println(map.entrySet());
    }
}
