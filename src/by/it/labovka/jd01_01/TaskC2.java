package by.it.labovka.jd01_01;

import java.math.BigInteger;
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
        System.out.println("DEC:" + a + "+" + b +  "=" + (a+ b));
        System.out.println("BIN:" + Integer.toBinaryString(a) + "+" +   Integer.toBinaryString(b) + "=" + Integer.toBinaryString(a+b));
        System.out.println("HEX:" + Integer.toHexString(a) + "+" + Integer.toHexString(b) + "=" + Integer.toHexString(a+b));
        System.out.println("OCT:" + Integer.toOctalString(a) + "+" + Integer.toOctalString(b) + "=" + Integer.toOctalString(a+b));


    }
//public static int toBinary(int number)
//{
//    String convert = Integer.toBinaryString(number);
//    return Integer.parseInt(convert, 2);
//}
//    public static int toOctal(int number)
//    {
//        String convert = Integer.toOctalString(number);
//        return Integer.parseInt(convert, 8);
//    }
//    public static int toHex(int number)
//    {
//        String convert = Integer.toHexString(number).toUpperCase();
//        return Integer.parseInt(convert,16);
//    }
}
