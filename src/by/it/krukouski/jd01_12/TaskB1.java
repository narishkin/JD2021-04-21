package by.it.krukouski.jd01_12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TaskB1 {
    private static final String WITHOUT = "[,.!?:;+\\-\\n]+";

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        line = line.replaceAll(WITHOUT, "");
        String[] string = line.split(" ");
        System.out.println("stringArray= " + Arrays.toString(string));
        for (String wordKey : string) {
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
