package by.it.karpovich.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static int month;
    public static double a;
    public static double b;
    public static double c;

    public static void main(String[] args) {
        step1();
        System.out.println("Введите номер месяца:");
        Scanner scan = new Scanner(System.in);
        month = scan.nextInt();
        step2(month);
        System.out.println("Введите a:");
        a = scan.nextDouble();
        System.out.println("Введите b:");
        b = scan.nextDouble();
        System.out.println("Введите c:");
        c = scan.nextDouble();
        step3(a,b,c);

    }

    private static void step3(double a, double b, double c) {
        double x1, x2, d;
        d = Math.pow(b,2) - (4 * a * c);
        if (d < 0){
            System.out.println("корней нет");
        } else if (d == 0){
            x1 = (-1 * b) / (2 * a);
            System.out.println("Корень: " + x1);
        } else {
            x1 = ((-1 * b) + Math.sqrt(d) )/ (2 * a);
            x2 = ((-1 * b) - Math.sqrt(d)) / (2 * a);
            System.out.println("Корень 1: " + x1);
            System.out.println("Корень 2: " + x2);
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
                break;
            default:
                System.out.println("нет такого месяца");
                break;
        }
    }

    private static void step1() {
        int[][] array = new int[5][5];
        int start = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                start = i * 5 + j;
                array[i][j] = start + 1;
                if (j < 4) {
                    System.out.print(array[i][j] + " ");
                } else {
                    System.out.print(array[i][j]);
                    System.out.println();
                }
            }

        }
    }

}




