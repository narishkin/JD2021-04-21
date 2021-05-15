package by.it.krukouski.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    static public final String string = "[а-яёА-ЯЁ\\s-,:;.!?]+";

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
        int differentLength = maxLength - text.length();
        int index = 0;
        for (int i = 0; i < differentLength; i++) {


        }
        return null;
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





