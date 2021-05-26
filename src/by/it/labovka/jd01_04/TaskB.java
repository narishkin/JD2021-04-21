package by.it.labovka.jd01_04;

import java.util.Scanner;
       //  Затем введите одномерный массив их фамилий (next() в сканере).
      //   Введите двумерный массив их зарплат за 4 квартала (N строк и 4 столбца).
     //    Зарплаты имеют тип int.
     //    Нужно для каждой фамилии выводить подсказку
     //    После подсказки можно через пробел вводить с консоли 4 цифры зарплат по кварталам (nextInt() в
      //  сканере).

      //   Постройте в консоли таблицу доходов людей по кварталам с фамилиями и
     //   итогом за год в последней колонке.
      //  B2. Посчитайте и выведите общую сумму всех выплат и среднеарифметическую
      //  квартальную зарплату с точностью как минимум до 4-го знака .
public class TaskB {
    public static void main(String[] args) {
        System.out.println("Введите число людей:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Введите людей:");
        String[] mas= new String[n];
        for (int i = 0; i < n; i++) {
            mas[i]=sc.next();
        }
        int[][] mas2 = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для: "+mas[i]);
            for (int j = 0; j < 4; j++) {

              mas2[i][j]=sc.nextInt();
            }

        }
        for (int i = 0; i <n ; i++) {
            System.out.print(mas[i] + ":");
          //  int z =
            for (int j = 0; j < 4; j++) {
                System.out.print(" " + mas2[i][j]);
            }
            System.out.println();
        }
        int all=0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <4 ; j++) {
                all=all+mas2[i][j];
            }
        }
        System.out.println("Итого " + all);
        System.out.println("Средняя " + all);
    }
}
