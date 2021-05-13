package by.it.sapazhkou.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {

        step1();
        step2();
    }

    private static void step1() {

        double firstValue = 0;
        double lastValue = 2;
        double step = 0.2;
        double yIteration = 0;
        double y = 0;


        double a = firstValue;
        while (firstValue <= a && a <= lastValue) {
            for (int i = 1; i <= 6; i++) {

                yIteration = yIteration + pow(7.0, a) - cos(i);

            }
            System.out.println("При a = " + a + " Сумма = " + yIteration);
            a = floor((a + step) * 100) / 100;
            y = y + yIteration;
            yIteration = 0;
        }
        System.out.println(y);
    }

    private static void step2() {

        double firstValue = -6;
        double lastValue = 2;
        double step = 0.5;
        double b = 0;
        double y;
        double alfa;
        double x = firstValue;

        while (firstValue <= x && x <= lastValue) {

            y = x / 2;

            if (-2 < y && y <= -1) {
                b = sin(pow(x, 2));
            } else if (-1 < y && y <= 0.2) {
                b = cos(pow(x, 2));
            } else if (y == 0.2) {
                b = cos(pow(x, 2)) / sin(pow(x, 2));
            } else {
                System.out.println("При x = " + x + " Результат не может быть получен");
            }
            alfa = log10(abs(b + 2.74));
            System.out.println("При x = " + x + " Результат = " + alfa);
            x = floor((x + step) * 100) / 100;

        }


    }


}
