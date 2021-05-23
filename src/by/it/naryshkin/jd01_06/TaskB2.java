package by.it.naryshkin.jd01_06;

import javax.crypto.spec.PSource;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("(?<=[а-я,])(\\n)");
        StringBuilder sb = new StringBuilder(Poem.text);
        Matcher m1 = p1.matcher(sb);
        while (m1.find()) {
            sb.setCharAt(m1.start(), ' ');
        }
        Pattern p2 = Pattern.compile("(, )|( - )|(: )|(\\... )|[! .]");
        Matcher m2 = p2.matcher(sb);
        String text2 = m2.replaceAll(" ");
        String text3 = text2.trim();
        Pattern p3 = Pattern.compile("( \\n)");
        Matcher m3 = p3.matcher(text3);
        String text4 = m3.replaceAll("\nJ");
        String[] array;
        array = text4.split("J");

        for (String s : array) {
            System.out.print(s);
        }
        System.out.println("");
        System.out.println("-------------------------------");
        Arrays.sort(array, Comparator.comparing(String::length));

        for (String s : array) {
            System.out.print(s);
        }
    }
}
