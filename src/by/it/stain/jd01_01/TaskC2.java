package by.it.stain.jd01_01;

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
import java.util.Scanner;

class TaskC2 {
    public static void main (String[] args){
        Scanner s = new Scanner (System.in);
        System.out.println("Введите первое число: ");
        int a = s.nextInt();
        System.out.println("Введите воторе число: ");
        int b = s.nextInt();
        int sum = a+b;
        System.out.println("DEC:"+a+"+"+b+"="+sum);

        String convert = Integer.toBinaryString(a);
        String convert1 = Integer.toBinaryString(b);
        String convert2 = Integer.toBinaryString(sum);
        System.out.println("BIN:"+convert+"+"+convert1+"="+convert2);

        String convert6 = Integer.toHexString(a);
        String convert7 = Integer.toHexString(b);
        String convert8 = Integer.toHexString(sum);
        System.out.println("HEX:"+convert6+"+"+convert7+"="+convert8);

        String convert3 = Integer.toOctalString(a);
        String convert4 = Integer.toOctalString(b);
        String convert5 = Integer.toOctalString(sum);
        System.out.println("OCT:"+convert3+"+"+convert4+"="+convert5);










    }


}
