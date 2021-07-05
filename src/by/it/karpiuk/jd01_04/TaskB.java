package by.it.karpiuk.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        System.out.println("Введите количество людей");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Введите их фамилии");
        String[] secondNames = new String[n];
        for (int i = 0; i < n; i++) {
            secondNames[i] = scanner.next();
        }
        int[][] sallary = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату "+secondNames[i]);
            for (int j = 0; j < 4; j++) {
                sallary[i][j]=scanner.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(secondNames[i]+" : ");
            for (int j = 0; j < 4; j++) {
                System.out.print(sallary[i][j]);
            }
            System.out.println();
        }

    }

}
