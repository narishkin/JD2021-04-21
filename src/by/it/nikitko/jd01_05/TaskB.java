package by.it.nikitko.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {
        double sum = 0;
        double a;


        for (a = 0; a <= 2; a = a + 0.2) {
            for (int x = 1; x <= 6; x++) {
                sum = sum + ((pow(7, a)) - (cos(x)));
            }
            System.out.printf("При a=%3.2f Сумма y = %12.10e %n", a, sum);
        }
    }
}
