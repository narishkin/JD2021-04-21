package by.it.marusich.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[]args) {
        step1();
        step2();
        step3();
    }
    private static void  step1(){
        double a = 756.13;
        double x = 0.3;
        double part1 = Math.cos(Math.pow(x*x+ Math.PI/6,5));
        double part2 = Math.sqrt(x* Math.pow(a,3));
        double part3 = Math.log(Math.abs((a-1.13 * x)/4));
        double z = part1 - part2 - part3;
        System.out.printf("A=%-8.4f X=%3.1f Z=%-12.6f", a, x, z);
    }
    private static void step2() {
        double a = 1.21f;
        double b = 0.371f;
        double y = tan(pow((a+b),2))- cbrt((a+1.5)) +a*pow(b,5) - b/(log(pow(a,2)));
        System.out.println("y = " + y);
    }

    private static void step3() {
        double x = 12.1;
        for (double a = -5; a <=12 ; a = a+3.75) {
            double f = exp(a*x) - 3.45*a;
            System.out.printf("а=%6.2f f=%g\n", a , f);
        }
    }
}



