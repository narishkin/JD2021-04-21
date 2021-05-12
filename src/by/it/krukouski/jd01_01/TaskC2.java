package by.it.krukouski.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и 4 раза выводит их сумму с обозначением системы счисления на экран в
ДЕСЯТИЧНОМ ДВОИЧНОМ ШЕСТНАДЦАТИРИЧНОМ ВОСЬМИРИЧНОМ виде

Вот пример ввода с клавиатуры:
34 26

Тогда вывод ожидается такой (обратите внимание на регистр букв):
DEC:34+26=60
BIN:100010+11010=111100
HEX:22+1a=3c
OCT:42+32=74

Допускается свободное использование любых методов стандартной библиотеки
*/
class TaskC2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int i = a+b;
        System.out.println("DEC" + ":" + a + "+" + b + "=" + i);

        String c = Integer.toString(a, 2);
        String d = Integer.toString(b, 2);
        String e = Integer.toString(i, 2);
        System.out.println("BIN" + ":" + c + "+" + d + "=" + e);

        String f = Integer.toString(a, 16);
        String g = Integer.toString(b, 16);
        String h = Integer.toString(i, 16);
        System.out.println("HEX" + ":" + f + "+" + g + "=" + h);

        String j = Integer.toString(a, 8);
        String k = Integer.toString(b, 8);
        String l = Integer.toString(i, 8);
        System.out.println("OCT" + ":" + j + "+" + k + "=" + l);

    }
}