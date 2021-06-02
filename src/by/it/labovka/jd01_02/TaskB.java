package by.it.labovka.jd01_02;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int v = sc.nextInt();
double a= sc.nextInt();
double b= sc.nextInt();
double c = sc.nextInt();
step1();
step2(v);
step3(a,b,c);
    }
    static void step1() {
        int m[][] = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println("");
        }
    }
    static void step2(int z) {
        int month = z;
        String monthString;
        switch (month) {
            case 1:  monthString = "январь";
                break;
            case 2:  monthString = "февраль";
                break;
            case 3:  monthString = "март";
                break;
            case 4:  monthString = "апрель";
                break;
            case 5:  monthString = "май";
                break;
            case 6:  monthString = "июнь";
                break;
            case 7:  monthString = "июль";
                break;
            case 8:  monthString = "август";
                break;
            case 9:  monthString = "сентябрь";
                break;
            case 10: monthString = "октябрь";
                break;
            case 11: monthString = "ноябрь";
                break;
            case 12: monthString = "декабрь";
                break;
            default: monthString = "нет такого месяца";
                break;
        }
        System.out.println(monthString);
    }

    static void step3(double a, double b, double c) {
        double x1 = 0;
        double x2 = 0;
        double d = b * b - 4 * a * c;
        if (d < 0) System.out.println("корней нет");
        else if (d == 0) {
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            System.out.println(x1);
        } else if (d > 0) {
            x1 = (-b - Math.sqrt(d)) / (a * a);
            x2 = (-b + Math.sqrt(d)) / (a * a);
            System.out.println(x1 + " " + x2);
        }
    }
}

