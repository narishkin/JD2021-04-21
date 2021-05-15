package by.it.stain.jd01_01;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должно появиться в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
import java.util.Scanner;

class TaskC1 {
    public static void main(String [] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int i = s.nextInt();
        System.out.println("Введите второе число: ");
        int a = s.nextInt();
        int Sum = i+a;
        System.out.println("Sum = " + Sum );



    }





}
