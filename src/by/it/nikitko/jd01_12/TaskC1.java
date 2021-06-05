package by.it.nikitko.jd01_12;

import java.util.*;


public class TaskC1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        HashMap<Integer, String> wordsWithoutRepeat = new HashMap();
        HashMap<Integer, String> wordsWithRepeat = new HashMap();

        String current = "";
        while (true) {
            current = scanner.nextLine();
            if (current.equals("end")){
                break;
            }
            input.add(current);
        }
        System.out.println();

        int key = 0;
        for (String value : input) {
                wordsWithRepeat.put(key, value);
                key++;
        }

        key = 0;
        for (String value : input) {
            if (!wordsWithoutRepeat.containsValue(value)) {
                wordsWithoutRepeat.put(key, value);
                key++;
            }
            key++;
        }
        System.out.println(wordsWithRepeat.toString());
        System.out.println(wordsWithoutRepeat.toString());
    }
}

