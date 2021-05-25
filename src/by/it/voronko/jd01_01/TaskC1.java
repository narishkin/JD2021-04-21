package by.it.voronko.jd01_01;

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
        System.out.println("vvedite chislo 34");
        Scanner scanner= new Scanner(System.in);
        int i=scanner.nextInt();
        System.out.println("vvedite chislo 26");
        int a=scanner.nextInt();
        int Sum=i+a;
        System.out.println("Sum"+"="+Sum);
    }



}
