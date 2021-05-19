package by.it.naryshkin.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        step1();
        Scanner sc = new Scanner(System.in);
        step2(sc.nextInt());
        step3(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());


    }

    static void step1() {
        int[] array = new int[25];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        for (int i = 0; i < array.length; i += 5) {
            for (int j = i; j < i + 5; j++) {
                System.out.print(array[j] + " ");

            }
            System.out.println();


        }

    }

    static void step2(int month) {
        String[] months = new String[]{"январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
        switch (month) {
            case 1:
                System.out.println(months[0]);
                break;
            case 2:
                System.out.println(months[1]);
                break;
            case 3:
                System.out.println(months[2]);
                break;
            case 4:
                System.out.println(months[3]);
                break;
            case 5:
                System.out.println(months[4]);
                break;
            case 6:
                System.out.println(months[5]);
                break;
            case 7:
                System.out.println(months[6]);
                break;
            case 8:
                System.out.println(months[7]);
                break;
            case 9:
                System.out.println(months[8]);
                break;
            case 10:
                System.out.println(months[9]);
                break;
            case 11:
                System.out.println(months[10]);
                break;
            case 12:
                System.out.println(months[11]);
                break;
            default:
                System.out.println("нет такого месяца");
        }

    }

    static void step3(double a, double b, double c) {

        double d = b * b - 4 * a * c;
        if (d > 0) {
            System.out.println((-b + Math.sqrt(d)) / (2 * a) + " " + ((-b - Math.sqrt(d)) / (2 * a)));


        } else if (d == 0) {
            System.out.println((-b / (2 * a)));

        } else {
            System.out.println("корней нет");

        }


    }
}
