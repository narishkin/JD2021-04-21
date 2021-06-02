package by.it.nakov.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = scanner.nextInt();

        String[] lastName = new String[numberOfPeople];
        int[][] salary = new int[numberOfPeople][4];
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

        for (int i = 0; i < numberOfPeople; i++) {
            System.out.printf("%-1s%1s", lastName[i], ":");
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-10s%d", "Квартал" + j);
            }
//            for (int j = 0; j < 4; j++) {
//                System.out.printf("%5d\t%10d%10d%10d%15s%n",
//                        salary[i][j], salary[i][j], salary[i][j], salary[i][j], "salary");
//            }
        }
        System.out.println("--------------------------------------------------------------------");
    }
}


// Постройте в консоли таблицу доходов людей по кварталам с фамилиями и
//итогом за год в последней колонке.

