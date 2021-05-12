package by.it.NakovMaks.jd01_01;

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
        System.out.println("Enter your first number: ");
        Scanner sc = new Scanner(System.in);
        int enter = Integer.parseInt(sc.nextLine());

        System.out.println("Enter your second number: ");
        int enter2 = Integer.parseInt(sc.nextLine());

        //DEC
        int decSum = enter + enter2;

        String binary = Integer.toBinaryString(enter);
        String binary2 = Integer.toBinaryString(enter2);
        String binarySum = Integer.toBinaryString(Integer.parseInt(binary,2) +
                Integer.parseInt(binary2, 2));

        String hex = Integer.toHexString(enter);
        String hex2 = Integer.toHexString(enter2);
        String hexSum = Long.toHexString(Long.parseLong(hex, 16) + Long.parseLong(hex2, 16));

        int oct = Integer.parseInt(Integer.toOctalString(enter));
        int oct2 = Integer.parseInt(Integer.toOctalString(enter2));
        int octSum = oct + oct2;

        System.out.println("DEC:" + enter + "+" + enter2 + "=" + decSum);
        System.out.println("BIN:" + binary + "+" + binary2 + "=" + binarySum);
        System.out.println("HEX:" + hex + "+" + hex2 + "=" + hexSum);
        System.out.println("OCT:" + oct + "+" + oct2 + "=" + octSum);
    }
}
