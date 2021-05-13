package by.it.krukouski.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();

    }

    private static void step1() {
        final double A = 756.13;
        final double X = 0.3;
        double z = cos(pow((X * X + PI / 6), 5)) - sqrt(X * pow(A, 3)) - log(abs((A - 1.12 * X) / 4));
        System.out.printf("A=%3.2f ,X=%1.1f ,z=%.8f\n", A, X, z);
    }

    private static void step2() {
        final double A = 1.21;
        final double B = 0.371;
        double y = tan(pow((A + B), 2)) - cbrt(A + 1.5) + A * pow(B, 5) - B / log(pow(A, 2));
        System.out.printf("A=%3.2f ,X=%1.1f ,y=%.8f\n", A, B, y);

    }

    private static void step3() {
        final double X = 12.1;
        for (double a = -5; a <= 12; a += 3.75) {
            double f = exp(a * X) - 3.45*a;
            System.out.printf("a=%.2f f=%.8f\n", a, f);
        }
    }
}
