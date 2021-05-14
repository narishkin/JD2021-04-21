package by.it.nikitko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static final String WORD_PATTERN = "[а-яёА-ЯЁ]+";


    public static void main(String[] args) {

        String[] poemByString = Poem.TEXT.split("\n");
        // System.out.println(poemByString[4]);

        int maxLenght = findMaxString(poemByString);
        //  System.out.println(maxLenght);
        formatString(poemByString,maxLenght);
    }


    private static int findMaxString(String[] poemByString) {
        int maxLenght = 0;
        for (String s : poemByString) {
            if (s.length() > maxLenght) {
                maxLenght = s.length();
            }
        }
        return maxLenght;
    }

    private static void formatString(String[] poemByString,int maxLenght) {
        int spaceNeeded = maxLenght-poemByString[0].length();

        StringBuilder string = new StringBuilder(poemByString[0]);
        Pattern patternWord = Pattern.compile(WORD_PATTERN);
        Matcher matcher = patternWord.matcher(string);
        while (matcher.find()) {
            String word = matcher.group();
        }

    }
}
