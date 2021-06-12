package by.it.mogonov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("[ \\-:,\\n]+");
        Matcher matcher = pattern.matcher(Poem.text);
        StringBuilder newSB = new StringBuilder();
        Pattern pattern1 = Pattern.compile("[.]{2,}");
        Matcher matcher1 = pattern1.matcher(sb.append(matcher.replaceAll(" ")));
        newSB.append(matcher1.replaceAll(""));
        //System.out.println(newSB);
        Pattern pattern2 = Pattern.compile("[.!]+");
        String [] arrayParts = pattern2.split(newSB);
        for (int i = 0; i < arrayParts.length; i++) {
            arrayParts[i] = arrayParts[i].trim();
        }
        for (int i = 0; i < arrayParts.length; i++) {
            for (int j = 0; j < arrayParts.length; j++) {
                if (arrayParts[i].length() <arrayParts[j].length()){
                    String temp = arrayParts[i];
                    arrayParts[i] = arrayParts[j];
                    arrayParts[j] = temp;
                }
            }

        }
        for (String arrayPart : arrayParts) {
            System.out.println(arrayPart);
        }

    }

}
