package by.it.karpovich.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();

    }

    private static void step3() {
        final double x = 12.1;
        for (double a = -5.0; a <= 12.0; a += 3.75) {
            double f = exp(a * x) - 3.45 * a;
            System.out.printf("F=%.8f a=%.2f \n", f, f);
        }
    }

    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double result = tan(pow(a + b, 2)) - cbrt(a + 1.5) + a * pow(b, 5) - (b / log(a * a));
        System.out.println(result);
    }

    private static void step1() {
        double a = 756.13;
        double x = 0.3;
        double result = cos(pow((x * x + Math.PI / 6), 5)) - sqrt(x * pow(a, 3)) - log(abs((a - 1.12 * x) / 4));
        System.out.println(result);
    }
}

