package by.it.zhurauleu.jd01_05;

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
                y += (pow(7, a) - cos(x));
            }
            System.out.printf("При а = %f y = %g\n", a, y);
        }
    }

    static void step2() {
        double alpha;
        double beta = 0;
        boolean checkBeta;
        for (double x = -5.5; x < 2; x += 0.5) {
            checkBeta = false;
            if (-2 < x / 2 && x / 2 <= -1) {
                beta = sin(x * x);
                checkBeta = true;
            } else if (-1 < x / 2 && x / 2 < 0.2) {
                beta = cos(x * x);
                checkBeta = true;
            } else if (x / 2 == 0.2) {
                beta = 1 / tan(x * x);
                checkBeta = true;
            }
            if (checkBeta) {
                alpha = log10(abs(beta + 2.74));
                System.out.printf("Для x/2 = %5.2f alpha = %g\n",x/2,alpha);
            } else {
                System.out.printf("Для x/2 = %5.2f не существует beta\n",x/2);
            }
        }

    }
}
