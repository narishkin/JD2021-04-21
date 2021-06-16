package by.it.nakov.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        task4();
        task5();
    }

    private static void task4() {
        for (double a = 0; a <= 2; a += 0.2) {
            double y = pow(7, a) * 6;
            for (double x = 1; x <= 6; x++) {
                y -= cos(x);
            }
            System.out.printf("При a=%2.2f Сумма y = %g\n", a, y);
        }
    }

    private static void task5() {
        double b = 0;
        for (double x = -6; x < 2; x += 0.5) {
            double x1 = x / 2;
            if (x1 > -2 && x1 <= -1) {
                b = sin(pow(x, 2));
            } else if (x1 > -1 && x1 < 0.2) {
                b = cos(pow(x, 2));
            } else if (x1 == 0.2) {
                b = 1 / tan(pow(x, 2));
            } else {
                System.out.printf("%-20s for x/2 = %5.3f\n","Undefined function", x / 2);
                continue;
            }
            double alfa = log10(abs(b + 2.74));
            System.out.printf("alfa =%8.6f %s for x/2 = %5.3f\n", alfa, " ", x / 2);
        }
    }
}
