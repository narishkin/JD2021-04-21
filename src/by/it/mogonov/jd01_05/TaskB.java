package by.it.mogonov.jd01_05;

import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.pow;

public class TaskB {
    public static void main(String[] args) {
        step1();
        //step2();
    }

    static void step1() {
        double y = 0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (int x = 1; x <= 6; x++) {
                y = y + pow(7, a) - cos(x);
            }
            System.out.printf("При a=%.2f  Сумма y=%g \n", a, y);
        }
    }

}

    //static void step2() {





