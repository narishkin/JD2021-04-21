package by.it.nakov.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = scanner.nextInt();

        String[] lastName = new String[numberOfPeople];
        int[][] salary = new int[numberOfPeople][4];
        int[] salaryResult = new int[4];
        int totalKvartal;
        int total = 0;
        double totalAverage = 0.0;
        for (int i = 0; i < numberOfPeople; i++) {
            lastName[i] = scanner.next();
        }
        for (int i = 0; i < numberOfPeople; i++) {
            System.out.println("Введите зарплату для " + lastName[i]);
            for (int l = 0; l < 4; l++) {
                salary[i][l] = scanner.nextInt();
            }
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-7s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("--------------------------------------------------------------------");

        for (int i = 0; i < salary.length; i++) {
            System.out.printf("%-10s", lastName[i] + ":");
            totalKvartal = 0;
            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf("%-10d", salary[i][j]);
                totalKvartal += salary[i][j];
            }
//            int str1 = 0, str2 = 0, str3 = 0, str4 = 0;
//            str1 += salary[i][0];
//            str2 += salary[i][1];
//            str3 += salary[i][2];
//            str4 += salary[i][3];
//            int strTotal = str1 + str2 + str3 + str4;

            salaryResult[i] = totalKvartal;
            total += totalKvartal;
            totalAverage = Double.parseDouble(String.valueOf((double) total / (double) numberOfPeople / 4));
            System.out.printf("%-10d", totalKvartal);
            System.out.println();
        }

        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-10s%-10d%n", "Итого", total);
        System.out.printf("%-10s%-10.4f\n", "Средняя", totalAverage);
    }
}


