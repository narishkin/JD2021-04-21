package by.it.krukouski.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] name = new String[n];
        for (int i = 0; i < name.length; i++) {
            name[i] = sc.next();
        }
        int[][] salary = new int[n][4];
        for (int i = 0; i < name.length; i++) {
            System.out.println("Введите зарплату для " + name[i]);
            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j] = sc.nextInt();
            }
            System.out.println();
        }
        System.out.printf("%10s%10s%10s%10s%10s%8s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("---------------------------------------------------------------");
        int total = 0;
        for (int i = 0; i < name.length; i++) {
            int sumSalary = 0;
            System.out.printf("%10s: ", name[i]);
            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf("%-10d", salary[i][j]);
                sumSalary += salary[i][j];
            }
            System.out.printf("%-8d%n", sumSalary);
            total += sumSalary;

        }
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-10s %-10d%n", "Итого", total);
        double average = (double) total / n / 4;
        System.out.printf("%-10s %-2.4f", "Среднее", average);
    }
}
