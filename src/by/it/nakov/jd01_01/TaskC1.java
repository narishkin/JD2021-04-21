package by.it.nakov.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должно появиться в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
class TaskC1 {
    public static void main(String[] args) {
        System.out.println("Enter your first number: ");
        Scanner sc = new Scanner(System.in);
        int enter = Integer.parseInt(sc.nextLine());
        System.out.println("Enter your second number: ");
        Scanner sc2 = new Scanner(System.in);
        int enter2 = Integer.parseInt(sc.nextLine());
        int sum = enter + enter2;
        System.out.println("Your result is: Sum = " + sum);

    }


}
