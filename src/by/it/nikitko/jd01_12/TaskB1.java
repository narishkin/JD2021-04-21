package by.it.nikitko.jd01_12;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static final String WORD_PATTERN = "[a-z'A-Z]+";
    //private static String[] words = new String[0];
    // private static int[] counts = new int[0];


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> words = new HashMap();
        Pattern patternWord = Pattern.compile(WORD_PATTERN);
        StringBuilder text = new StringBuilder();

       String value =scanner.nextLine();

        Matcher matcherWord = patternWord.matcher(value);
        while (matcherWord.find()) {
            String word = matcherWord.group();
            if (word == "had") {
                break;
            }
            if (!words.containsKey(word)) {
                words.put(word, 0);
            }
            if (words.containsKey(word)) {
                words.put(word, words.get(word) + 1);
            }


        }
        System.out.println(words.entrySet());
    }
}
/*A creaking of the kind made by the weight carried by one foot after another along a
wooden floor. I listened. I felt the apertures of my ears distend with concentration. Again:
the creaking. I was waiting for it; waiting to hear if it indicated that feet were moving from
room to room, coming up the passage — to my door. I have no burglar bars, no gun under the
pillow, but I have the same fears as people who do take thse precautions, and my
windowpanes are thin as rime, could shatter like a wineglass. A woman was murdered (how
do they put it) in broad daylight in a house two blocks away, last year, and the fierce dogs
who guarded an old widower and his collection of antique clocks were strangled before he
was knifed by a casual laborer he had dismissed without pay. */