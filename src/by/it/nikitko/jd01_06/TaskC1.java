package by.it.nikitko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static final String WORD_PATTERN = "[-.,а-яёА-ЯЁ:]+";


    public static void main(String[] args) {

        String[] poemByString = Poem.TEXT.split("\n");
        int maxLength = findMaxString(poemByString);
       for (String stringI : poemByString) {
            formatString(stringI, maxLength);
       }
      }


    private static void formatString(String stringI, int maxLength) {
        int spaceNeeded = maxLength - stringI.length();
        StringBuilder string = new StringBuilder(stringI);

        Pattern patternWord = Pattern.compile(WORD_PATTERN);
        Matcher matcher = patternWord.matcher(string);

        while (spaceNeeded > 0) {
            matcher.reset();
            int position=0;
            while (matcher.find(position) && !matcher.hitEnd()&&spaceNeeded>0) {
                position = matcher.end();
                string.insert(position, ' ');
                spaceNeeded--;
            }
        }
        System.out.println(string);

    }

    private static int findMaxString(String[] poemByString) {
        int maxLength = 0;
        for (String s : poemByString) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }
        return maxLength;
    }

}
