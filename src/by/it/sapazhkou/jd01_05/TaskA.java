package by.it.sapazhkou.jd01_05;

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

        double part1 = cos(pow((x * x + PI / 6), 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log(abs((a - 1.12 * x) / 4));
        double z = part1 - part2 - part3;
        System.out.println(z);
        z = cos(pow((x * x + PI / 6), 5)) - sqrt(x * pow(a, 3)) - log(abs((a - 1.12 * x) / 4));
        System.out.println(z);

    }

    private static void step2() {

        double a = 1.21;
        double b = 0.371;

        double y = tan(pow((a + b), 2)) - cbrt(a + 1.5) + a * pow(b, 5) - b / (log(pow(a, 2)));
        System.out.println(y);

    }

    private static void step3() {

        double x = 12.1;
        double firstValue = -5;
        double lastValue = 12;
        double step = 3.75;
        double a = firstValue;

        for (int i = 0; i < ((lastValue - firstValue) / step); i++) {
            double f = exp(a * x) - 3.45 * a;
            System.out.printf("при а = % -4.2f f = % -10.7f\n",a,f);
            a = a + step;
        }
    }
}
