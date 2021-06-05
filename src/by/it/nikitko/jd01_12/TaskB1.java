package by.it.nikitko.jd01_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static final String WORD_PATTERN = "[a-z'A-Z]+";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> words = new  HashMap();
        Pattern patternWord = Pattern.compile(WORD_PATTERN);
        List<String> input = new ArrayList<>();
        String current = "";
        while (!current.equals("end")) {
            current = scanner.nextLine();
            input.add(current);
        }
        for (String value : input) {
            Matcher matcherWord = patternWord.matcher(value);
            while (matcherWord.find()) {
                String word = matcherWord.group();
                if (!words.containsKey(word)) {
                    words.put(word, 0);
                }
                if (words.containsKey(word)) {
                    words.put(word, words.get(word) + 1);
                }
            }
        }
        System.out.println(words.entrySet());
    }
}
