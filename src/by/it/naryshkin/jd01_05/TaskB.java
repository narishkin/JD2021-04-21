package by.it.naryshkin.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double y = 0;
        double a;
        double x;
        for (a = 0; a <= 2; a = a + 0.2) {
            for (x = 1; x <= 6; x++) {
                y = y + pow(7, a) - cos(x);
            }
            System.out.printf("y=%-10g при a=%4.2f\n", y, a);
        }
    }

    private static void step2() {
        double alpha;
        double beta;
        System.out.println();

        for (double x = -6; x <= 2; x = x + 0.5) {
            if (x / 2 > -2 && x / 2 <= -1) {
                beta = sin(x * x);
            } else if (x / 2 > -1 && x / 2 < 0.2) {
                beta = cos(x * x);
            } else if (x / 2 == 0.2) {
                beta = 1 / (tan(x * x));
            } else {
                System.out.printf("%-20s for x/2 = %5.3f\n", "Undefined function", x / 2);
                continue;
            }
            alpha = log10(abs(beta + 2.74));
            System.out.printf("Alpha=%8.6f %s for x/2 = %5.3f\n", alpha, "     ", x / 2);
        }
    }
}
