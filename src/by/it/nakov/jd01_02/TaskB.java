package by.it.nakov.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        System.out.println("TaskA ");
        step1();
        System.out.println(" ==== ==== ==== ====");

        Scanner scanner = new Scanner(System.in);

        System.out.println("TaskB.  Enter a number equal to the ordinal number of the month (from 1 to 12): ");
        int month = scanner.nextInt();
        step2(month);
        System.out.println(" ==== ==== ==== ====");

        System.out.println("TaskC ");
        System.out.println("Enter A: ");
        double a = scanner.nextDouble();
        System.out.println("Enter B: ");
        double b = scanner.nextDouble();
        System.out.println("Enter C: ");
        double c = scanner.nextDouble();
        step3(a, b, c);
        System.out.println(" ==== ==== ==== ====");
    }

    private static void step1() {
        int[][] matrix = new int[5][5];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 5 * i + 1 + j;
                System.out.print(matrix[i][j] + " ");
            }
        }
    }

    private static void step2(int month) {
        String monthName;
        switch (month) {
            case 1:
                monthName = "январь";
                break;
            case 2:
                monthName = "февраль";
                break;
            case 3:
                monthName = "март";
                break;
            case 4:
                monthName = "апрель";
                break;
            case 5:
                monthName = "май";
                break;
            case 6:
                monthName = "июнь";
                break;
            case 7:
                monthName = "июль";
                break;
            case 8:
                monthName = "август";
                break;
            case 9:
                monthName = "сентябрь";
                break;
            case 10:
                monthName = "октябрь";
                break;
            case 11:
                monthName = "ноябрь";
                break;
            case 12:
                monthName = "декабрь";
                break;
            default:
                monthName = "нет такого месяца";
                break;
        }
        System.out.println(monthName);
    }

    static void step3(double a, double b, double c) {
        double discr = b * b - 4 * a * c;
        if (discr > 0) {
            double x1 = (-b - Math.sqrt(discr)) / (2 * a);
            double x2 = (-b + Math.sqrt(discr)) / (2 * a);
            System.out.println("Корни уравнения: x1 = " + x1 + ", x2 = " + x2);
        } else if (discr == 0) {
            double x;
            x = -b / (2 * a);
            System.out.println("Уравнение имеет единственный корень: x = " + x);
        } else {
            System.out.println("корней нет");

        }

    }
}

