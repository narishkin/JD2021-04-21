package by.it.naryshkin.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("\\n");
        Matcher m1 = p1.matcher(Poem.text);
        String s2 = m1.replaceAll("\nJ");

//        System.out.println(s2);
        String[] array;
        array = s2.split("J");
//        Pattern removeN = Pattern.compile("\\n");
//        String rN;
//        for (int i = 0; i < array.length; i++) {
//            rN = array[i].replace("\n", "");
//            array[i] = rN;
//        }

        int maxLength = 0;
        /*Определение максимальной длины строки в массиве*/
        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i]);
            if (array[i].length() > maxLength) {
                maxLength = array[i].length();
            }
        }

        Pattern p2 = Pattern.compile(" ");

        for (int i = 0; i < array.length; i++) {
            Matcher m2 = p2.matcher(array[i]);
            int diff = maxLength - array[i].length();
//            System.out.println("Разница " + diff + " для строки " + i);
            int numberOfMatched = 0;
            while (m2.find()) {
                numberOfMatched++;
            }
//            System.out.println("NOM:" + numberOfMatched + " для строки " + i);
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

            Pattern p3 = Pattern.compile("(?<=[А-Яа-яёЁ,.-:])( )");
            Matcher m3 = p3.matcher(array[i]);
            int counter = 0;
            StringBuilder sb = new StringBuilder(array[i]);
            while (m3.find()) {
                int start;
//                System.out.println(m3.group());
                spacesRemain = diff % numberOfMatched;
//                System.out.println("оставшихся пробелов" + spacesRemain);
                if (counter < spacesRemain && i<array.length-1) {
                    start = m3.start();
                    start = start + counter;
//                    System.out.println(i);
//                    System.out.println("start" + start);
                    sb.insert(start, " ");

                    counter++;
                }
            }
            array[i] = sb.toString();
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
