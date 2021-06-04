package by.it.mogonov.jd01_05;

import static java.lang.StrictMath.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    static void step1() {
        double y = 0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (int x = 1; x <= 6; x++) {
                y = y + pow(7, a) - cos(x);
            }
            System.out.printf("При a=%.2f  Сумма y=%g \n", a, y);
        }
    }


    static void step2() {
        for (double x = -5.5; x < 2; x += 0.5) {
            double half = x / 2;
            double squared = pow(x, 2);
            double beta = 0;
            if (half > -2 && half <= -1) {
                beta = sin(squared);
            } else if (half > -1 && half < 0.2) {
                beta = cos(squared);
            } else if (half == 0.2) {
                beta = atan(squared);
            } else {
                System.out.println(" При x/2=" + half + "вычисления не определены");
            }
            double a = log10(abs(beta + 2.74));
            System.out.println(x + " " + a);

        }

    }
}




