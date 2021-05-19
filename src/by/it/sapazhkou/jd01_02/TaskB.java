package by.it.sapazhkou.jd01_02;

import java.util.Scanner;
import java.util.Arrays;

public class TaskB {
    public static void main(String[] args) {

        int month;
        Scanner sc = new Scanner(System.in);
        step1();
        month = sc.nextInt();
        step2(month);
        double a = sc.nextInt();
        double b = sc.nextInt();
        double c = sc.nextInt();
        step3(a, b, c);


    }

    private static void step1() {

        int[][] array = new int[5][5];
        int a = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = a;
                System.out.print(array[i][j] + " ");
                a = a + 1;
            }
            System.out.println();
        }
    }

    private static void step2(int month) {

        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
            default:
                System.out.println("нет такого месяца");
        }
    }

    private static void step3(double a, double b, double c) {

        double d = (b * b) - (4 * a * c);
        if (d > 0) {
            double x1 = (-1*b + Math.sqrt(d))/(2*a);
            double x2 = (-1*b - Math.sqrt(d))/(2*a);
            System.out.print(x1+" "+x2);
            System.out.println();
        } else if (d == 0 ) {
            double x = (-1) * (b / (2 * a));
            System.out.println(x);
        } else {
            System.out.println("корней нет");
        }

    }


}



