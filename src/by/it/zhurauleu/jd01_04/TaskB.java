package by.it.zhurauleu.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int employeesCount = input.nextInt();
        String[] employees = new String[employeesCount];

        for (int i = 0; i < employees.length; i++) {
            employees[i] = input.next();
        }

        int[][] budget = new int[employeesCount][4];
        for (int i = 0; i < budget.length; i++) {
            System.out.println("Введите зарплату для " + employees[i]);
            for (int j = 0; j < 4; j++) {
                budget[i][j] = input.nextInt();
            }
        }
        int[] yearSalary = new int[employeesCount];
        int totalYearBudget = 0;
        double averageSalary;
        System.out.println("---------------------------------------------------------");
        System.out.println("   Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итого");
        System.out.println("---------------------------------------------------------");
        for (int i = 0; i < employeesCount; i++) {
            System.out.printf("%10s: ", employees[i]);
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-10d", budget[i][j]);
                yearSalary[i] += budget[i][j];
                totalYearBudget += budget[i][j];
            }
            System.out.printf("%-5d\n", yearSalary[i]);
        }
        averageSalary = (double)totalYearBudget / (employeesCount * 4);
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-12s%-10d\n", "Итого", totalYearBudget);
        System.out.printf("%-12s%-10.4f", "Средняя", averageSalary);
    }
}
