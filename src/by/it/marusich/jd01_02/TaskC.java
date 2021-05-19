package by.it.marusich.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        int array[][];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        array = step1(n);
    }
    static int[][] step1(int n) {
        boolean minFind = false;
        boolean maxFind = false;
        int size = n + n + 1;
        int[][] array = new int[size][size];
        int minBorder = -1 * n;
        int maxBorder = n;
        while (!minFind || !maxFind) {
            for (int i = 0; i < array.length; i++) {
                for (int g = 0; g < array.length; g++) {
                    int rnd = (int) (Math.random() * size) + minBorder;
                    array[i][g] = rnd;
                    if (rnd == minBorder) {
                        minFind = true;
                    } else if (rnd == maxBorder) {
                        maxFind = true;
                    }
                }
            }
        }
        for (int[] ints : array) {
            for (int g = 0; g < array.length; g++) {
                System.out.print(ints[g] + " ");
            }
            System.out.print("\n");
        }
        return array;
    }
}