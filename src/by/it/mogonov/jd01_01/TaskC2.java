package by.it.mogonov.jd01_01;

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

        int i = sc.nextInt();

        int k = sc.nextInt();

        int sum = i + k;

        String iBin = Integer.toBinaryString(i);
        String kBin = Integer.toBinaryString(k);
        String sumBin = Integer.toBinaryString(sum);

        String iHex = Integer.toHexString(i);
        String kHex = Integer.toHexString(k);
        String sumHex = Integer.toHexString(sum);

        String iOkt = Integer.toOctalString(i);
        String kOkt = Integer.toOctalString(k);
        String sumOkt = Integer.toOctalString(sum);

        System.out.println("DEC:" + i + "+" + k + "=" + sum);
        System.out.println("BIN:" + iBin + "+" + kBin + "=" + sumBin);
        System.out.println("HEX:" + iHex + "+" + kHex+ "=" + sumHex);
        System.out.println("OCT:" + iOkt + "+" + kOkt+ "=" + sumOkt);
    }


}

