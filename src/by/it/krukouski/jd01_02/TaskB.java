package by.it.krukouski.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        step1();
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        step2(i);
        double a = sc.nextInt();
        double b = sc.nextInt();
        double c = sc.nextInt();
        step3(a, b, c);

    }

    static void step1() {
        int[][] array = new int[5][5];
        int i, j;
        int h = 1;
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                array[i][j] = h;
                h++;
            }
        }
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) System.out.print(array[i][j] + " ");
            System.out.println();
        }

    }


    static void step2(int month) {
        switch (month) {
            case 1: {
                System.out.println("январь");
                break;
            }
            case 2: {
                System.out.println("февраль");
                break;
            }
            case 3: {
                System.out.println("март");
                break;
            }
            case 4: {
                System.out.println("апрель");
                break;
            }
            case 5: {
                System.out.println("май");
                break;
            }
            case 6: {
                System.out.println("июнь");
                break;
            }
            case 7: {
                System.out.println("июль");
                break;
            }
            case 8: {
                System.out.println("август");
                break;
            }
            case 9: {
                System.out.println("сентябрь");
                break;
            }
            case 10: {
                System.out.println("октябрь");
                break;
            }
            case 11: {
                System.out.println("ноябрь");
                break;
            }
            case 12: {
                System.out.println("декабрь");
                break;
            }
            default: {
                System.out.println("нет такого месяца");
            }

        }
    }

    static void step3(double a, double b, double c) {
        double d = b * b - 4 * a * c;
        double x1, x2;
        if (d > 0) {
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println("Два корня: " + "x1= " + x1 + " " + "x2= " + x2);
        } else if (d == 0) {
            x1 = -b / (2*a);
            System.out.println("Один корень: " + "x= " + x1);
        } else {
            System.out.println("корней нет");
        }
    }
}
