package by.it.karpiuk.jd01_05;

import static java.lang.Math.cos;
import static java.lang.Math.pow;

public class TaskB {
    public static void main(String[] args) {
        step1();

    }

    private static void step1() {

        double res=0;
        for (double a =0; a<=2; a+=0.2){
            for (int x = 1; x <=6 ; x++) {
                 res +=(pow(7, a)) - (cos(x));
            }System.out.printf("a=%2.2f  y = %f \n", a, res);
        }
    }
}
