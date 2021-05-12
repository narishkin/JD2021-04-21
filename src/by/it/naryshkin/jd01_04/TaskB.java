package by.it.naryshkin.jd01_04;

import java.util.Scanner;
public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] surnamesArray = new String[n];
        for (int i = 0; i < n; i++) {
            surnamesArray[i] = sc.next();
        }
        int[][] salaries = new int[n][4];
        for (int i = 0; i < surnamesArray.length; i++) {
            System.out.println("Введите зарплату для " + surnamesArray[i] + ":");
            for (int j = 0; j < 4; j++) {
                salaries[i][j] = sc.nextInt();
            }
        }
        printSalaryTable(surnamesArray, salaries);
    }

    private static void printSalaryTable(String[] surnamesArray, int[][] salaries) {
        System.out.print("------------------------------------------------------------\n");
        System.out.printf("%-15s%-10s%-10s%-10s%-10s%-10s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        int sumSalaries = 0;
        for (int i = 0; i < salaries.length; i++) {
            System.out.printf("%-15s", surnamesArray[i]+":");
            int sumYear = 0;
            for (int j = 0; j < salaries[0].length; j++) {
                sumYear = sumYear + salaries[i][j];
                System.out.printf("%-10d", salaries[i][j]);
            }
            sumSalaries = sumSalaries + sumYear;
            System.out.printf("%-10d", sumYear);
            System.out.println();
        }
        System.out.print("------------------------------------------------------------\n");
        System.out.printf("%-10s%-10d\n", "Итого", sumSalaries);
        float midSalary = (float) sumSalaries / (salaries.length * salaries[0].length);
        System.out.printf("%-10s%-10.4f\n", "Средняя", midSalary);
    }
}
