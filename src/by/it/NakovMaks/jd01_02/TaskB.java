package by.it.NakovMaks.jd01_02;

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
        String monthName = switch (month) {
            case 1 -> "январь";
            case 2 -> "февраль";
            case 3 -> "март";
            case 4 -> "апрель";
            case 5 -> "май";
            case 6 -> "июнь";
            case 7 -> "июль";
            case 8 -> "август";
            case 9 -> "сентябрь";
            case 10 -> "октябрь";
            case 11 -> "ноябрь";
            case 12 -> "декабрь";
            default -> "нет такого месяца";
        };
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

