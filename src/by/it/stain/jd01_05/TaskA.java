package by.it.stain.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }


    private static void step1() {
        double a = 756.13;
        double x = 0.3;
        double part1 = cos(pow(x * x + PI / 6, 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log(abs((a - 1.12 * x) / 4));
        double z = part1 - part2 - part3;
        System.out.printf("A=%f-8.4f X=%3.1f Z=%-12.6f\n", a, x, z);

    }

    private static void step2() {
        final double a = 1.21;
        final double b = 0.371;
        double y = (tan(pow(a+b,2)))-(cbrt(a+1.5))+(a*pow(b,5))-(b/log(a*a));
        System.out.printf("a=%-3.2f b=%-4.3f y=%-12.6f\n",a,b,y);

    }

    private static void step3() {
        final double X = 12.1;
        for (double a = -5; a <= 12; a += 3.75) {
            double f = exp(a * X) - 3.45 * a;
            System.out.printf("a=%f-8.4 X=%3.1f f=%-12.6g\n", a, X, f);


        }
    }
}

