package by.it.karpovich.jd01_01;

import java.util.Scanner;

public class TaskC3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int weight = scan.nextInt();
        System.out.println(getWeight(weight));
    }

    public static double getWeight(int weight) {
        double doubleweight = Double.parseDouble(String.valueOf(weight));

        doubleweight = doubleweight / 9.81 * 3.86;
        doubleweight = doubleweight - (doubleweight % 0.001);
        if (doubleweight % 0.01 - (doubleweight % 0.001) >= 0.005) {
            doubleweight = doubleweight - (doubleweight % 0.01) + 0.01;
        } else {
            doubleweight = doubleweight - (doubleweight % 0.01);
        }
        return doubleweight;
    }

}