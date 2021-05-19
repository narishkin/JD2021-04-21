package by.it.sapazhkou.jd01_06;

import java.util.Random;
import java.util.regex.Pattern;

public class TaskC2 {

    public static void main(String[] args) {

        long startTimeSlow = System.nanoTime();
        System.out.println(slow(Poem.text));
        long timeSlow = System.nanoTime() - startTimeSlow;
        System.out.println(timeSlow);

        long startTimeFast = System.nanoTime();
        System.out.println(fast(Poem.text));
        long timeFast = System.nanoTime() - startTimeFast;
        System.out.println(timeFast);

        System.out.println(timeSlow/timeFast);


    }

    static String slow(String text) {
        String str = "";
        Pattern pattern = Pattern.compile("[\\s\\-\\.\\,\\!\\:]+");
        String[] arrayWorld = pattern.split(Poem.text);
        int valueSeed = 1;

        while (str.length() < 100000) {
            Random rnd = new Random(valueSeed);
            int value = rnd.nextInt(arrayWorld.length);
            str = str + arrayWorld[value] + " ";
            if (valueSeed < arrayWorld.length) {
                valueSeed++;
            } else {
                valueSeed = 1;
            }
        }
        return str;
    }

    static String fast(String text) {
        String str = "";
        Pattern pattern = Pattern.compile("[\\s\\-\\.\\,\\!\\:]+");
        String[] arrayWorld = pattern.split(Poem.text);
        StringBuilder sb = new StringBuilder();
        int valueSeed = 1;

        while (sb.length() < 100000) {
            Random rnd = new Random(valueSeed);
            int value = rnd.nextInt(arrayWorld.length);
            sb = sb.append(arrayWorld[value] + " ");
            if (valueSeed < arrayWorld.length) {
                valueSeed++;
            } else {
                valueSeed = 1;
            }
        }
        return str = sb.toString();
    }
}
