package by.it.zhurauleu.jd01_12;

import java.util.HashMap;
import java.util.Scanner;

public class TaskB1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<String, Integer> wordsFrequency = new HashMap<>();
        for (; ; ) {
            String inputWord = input.next().replaceAll("[,.!;?—)(]", "");
            if (inputWord.equals("end")) break;
            else if (wordsFrequency.containsKey(inputWord)) {
                Integer wordFrequency = wordsFrequency.get(inputWord) + 1;
                wordsFrequency.put(inputWord, wordFrequency);
            } else {
                wordsFrequency.put(inputWord, 1);
            }
        }
        System.out.println(wordsFrequency.toString().replaceAll("[,]", "\n"));
    }
}
