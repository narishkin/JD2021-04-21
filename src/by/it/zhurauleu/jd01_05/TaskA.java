package by.it.zhurauleu.jd01_05;

import static java.lang.Math.*;


public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }

    static void step1() {
        double x = 0.3;
        double a = 756.13;
        double part1 = cos(pow(x * x + PI / 6, 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log(abs((a - 1.12 * x) / 4));
        double z = part1 - part2 - part3;
        System.out.println(z);
    }

    static void step2() {
        double a = 1.21;
        double b = 0.371;
        double y = tan(pow(a + b, 2)) - cbrt(a + 1.5) + a * pow(b, 5) - b / (log(a * a));
        System.out.println(y);
    }

    static void step3() {
        double x = 12.1;
        double deltaA = 3.75;
        double aMin = -5;
        double aMax = 12;
        double f;
        for (double a = aMin; a <= aMax; a += deltaA) {
            f = pow(E, a * x) - 3.45 * a;
            System.out.printf("x = %4.1f a = %4.2f f = %g\n",x,a,f);
        }
    }
}


