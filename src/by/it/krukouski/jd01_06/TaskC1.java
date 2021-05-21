package by.it.krukouski.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    static public final String string = "[^\\n]+";

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.TEXT);
        int maxLengthString = maxLength(text);
        Pattern pattern = Pattern.compile(string);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String StringWithSpace = addSpaceToString(matcher.group(), maxLengthString);
            System.out.println(StringWithSpace);
        }


    }

    private static String addSpaceToString(String text, int maxLength) {
        StringBuilder string = new StringBuilder(text);
        int differentLength = maxLength - text.length(); //разница символов между максимальной строкой и проверяемой
        int indexSpace = 0;
        int repeatCycle = 0; // переменная количества повтора цикла, если разница символов больше, чем пробелов в строке
        for (int i = 0; i < differentLength; i++) {
            indexSpace = string.indexOf(" ", indexSpace);
            if (indexSpace < 0) {
                indexSpace = string.indexOf(" ", 0);
                repeatCycle++;
            }
            string.insert(indexSpace + 1, " ");
            indexSpace = indexSpace + repeatCycle + 2;

        }
        return string.toString();

    }


    private static int maxLength(StringBuilder text) {
        Pattern pattern = Pattern.compile(string);
        Matcher matcher = pattern.matcher(text);
        int maxLength = 0;
        while (matcher.find()) {
            maxLength = Math.max(maxLength, matcher.group().length());
        }
        return maxLength;
    }
}





