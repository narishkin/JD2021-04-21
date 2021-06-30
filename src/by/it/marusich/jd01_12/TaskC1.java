package by.it.marusich.jd01_12;

import java.util.HashMap;
import java.util.Scanner;

public class TaskC1 {
    private static String text = "";

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        HashMap<Integer, String> map1 = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        for (; ; ) {
            String value = sc.nextLine();
            if (value.equals("end")) {
                break;
            }
            text = text.concat(value + "\n");
        }
        String[] arrayWords = text.split("\n");
        int key = 0;
        for (String word : arrayWords) {
            map.put(key, word);
            key++;
        }
        int key1 = 0;
        for (String word : arrayWords) {
            if (!map1.containsValue(word)) {
                map1.put(key1, word);
                key1++;
            }
            key1++;
        }
        System.out.println(map.toString());
        System.out.println(map1.toString());

    }

}

