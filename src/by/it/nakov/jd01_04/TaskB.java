package by.it.nakov.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] lastName = new String[Integer.parseInt(scanner.next())];
        int[][] salary = new int[n][4];
        for (int i = 0; i < lastName.length; i++) {
            System.out.println("LastName: " + lastName + "\n");
            for (int j = 0; j < salary.length; j++) {
                System.out.println("Enter salary for " + lastName[i]);
            }
        }

    }


    // Затем введите одномерный массив их фамилий (next() в сканере).
    // Введите двумерный массив их зарплат за 4 квартала (N строк и 4 столбца).
    // Зарплаты имеют тип int.
    // Нужно для каждой фамилии выводить подсказку
    // После подсказки можно через пробел вводить с консоли 4 цифры зарплат по кварталам (nextInt() в
    //сканере).
    //
    // Постройте в консоли таблицу доходов людей по кварталам с фамилиями и
    //итогом за год в последней колонке.
}
