package by.it.naryshkin.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("\\n");
        Matcher m1 = p1.matcher(Poem.text);
        String s2 = m1.replaceAll("\nJ");

        String[] array;
        array = s2.split("J");

        int maxLength = 0;
        /*Определение максимальной длины строки в массиве*/
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() > maxLength) {
                maxLength = array[i].length();
            }
        }

        Pattern p2 = Pattern.compile(" ");

        for (int i = 0; i < array.length; i++) {
            Matcher m2 = p2.matcher(array[i]);
            int diff = maxLength - array[i].length();
            int numberOfMatched = 0;
            while (m2.find()) {
                numberOfMatched++;
            }
            m2 = p2.matcher(array[i]);
            int amountOfSpacesToAdd = diff / numberOfMatched;
            String temp = "";
            int spacesRemain;
            StringBuilder sbSpaces;
            while (m2.find()) {
                sbSpaces = new StringBuilder("");
                for (int j = 0; j <= amountOfSpacesToAdd; j++) {
                    sbSpaces.append(" ");
                }
                temp = array[i].replace(m2.group(), sbSpaces.toString());
            }
            array[i] = temp;

            Pattern p3 = Pattern.compile("(?<=[А-Я-а-яёЁ,.:])( )");
            Matcher m3 = p3.matcher(array[i]);
            int counter = 0;
            StringBuilder sb = new StringBuilder(array[i]);
            while (m3.find()) {
                int start;
                spacesRemain = diff % numberOfMatched;
                if (counter < spacesRemain && i<array.length-1) {
                    start = m3.start();
                    start = start + counter;

                    sb.insert(start, " ");

                    counter++;
                }
            }
            array[i] = sb.toString();
        }
        StringBuilder sbFinal = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sbFinal.append(array[i]);
        }
        System.out.println(sbFinal);
    }
}
