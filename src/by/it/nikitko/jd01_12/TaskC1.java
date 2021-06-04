package by.it.nikitko.jd01_12;

import java.util.*;


public class TaskC1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> words = new HashMap();
        HashMap<String, Integer> keys = new HashMap();

        List<String> input = new ArrayList<>();
        String current = "";
        while (!current.equals("end")) {
            current = scanner.nextLine();
            input.add(current);
        }
        int key = 0;
        //   System.out.println(input);// test
        for (String value : input) {
            words.put(key, value);
            key++;
        }


        System.out.println(words.toString());

    }
}

