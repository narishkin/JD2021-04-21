package by.it.karpovich.jd01_01;

import java.util.Scanner;

public class TaskC2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        int sum = n1 + n2;
        System.out.println("DEC:" + n1 + "+" + n2 + "=" + sum);
        System.out.println("BIN:" + Integer.toBinaryString(n1) + "+" + Integer.toBinaryString(n2) + "=" + Integer.toBinaryString(sum));
        System.out.println("HEX:" + Integer.toHexString(n1) + "+" + Integer.toHexString(n2) + "=" + Integer.toHexString(sum));
        System.out.println("OCT:" + Integer.toOctalString(n1) + "+" + Integer.toOctalString(n2) + "=" + Integer.toOctalString(sum));
    }
}
