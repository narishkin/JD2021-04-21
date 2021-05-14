package by.it.krukouski.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step4();
        step5();
    }

    private static void step4() {
        for (double a = 0; a <= 2; a += 0.2) {
            double y = 0;
            for (int x = 1; x <= 6; x++) {
                y += (pow(7, a) - cos(x));
            }
            System.out.printf("a=%1.1f ,y=%f\n", a, y);
        }

    }

    private static void step5() {
        for (double x = -6; x < 2; x+=0.5) {
            double b = 0;
            if ((x / 2) > -2 && (x / 2) <= -1) {
                b = sin((pow(x, 2)));
            } else if ((x / 2) > -1 && (x / 2) < 0.2) {
                b = cos(pow(x, 2));
            } else if ((x / 2) == 0.2) {
                b = (cos(pow(x, 2))) / sin(pow(x, 2));
            } else {
                System.out.printf("При x/2=%.2f вычисление невозможно\n", x/2);
            }
            if (b == 0) {
                System.out.println();
            } else {
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%.2f а=%f\n", x/2, a);

            }
        }
    }
}
