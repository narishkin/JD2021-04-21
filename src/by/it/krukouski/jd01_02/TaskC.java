package by.it.krukouski.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        step1(n);
        int[][] array = step1(n);
        step2(array);
        //step3(array);
    }

    static int[][] step1(int n) {
        int[][] array = new int[n][n];
        int min = array[0][0];
        int max = array[0][0];
        do {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
                    if (min > array[i][j]) {
                        min = array[i][j];
                    }
                    if (max < array[i][j]) {
                        max = array[i][j];
                    }
                }
            }
        }
        while (!(min == -n) && !(max == n));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) System.out.print(array[i][j] + " ");
            System.out.println();
        }
        System.out.println();
        return array;
    }

    static int step2(int[][] array) {
        int first = 0;
        int second = 0;
        int sum = 0;
        int j1 = 0;
        int j2 = 0;
        for (int i = 0; i < array.length; i++) {
            outer:
            for (int j = 0; j < array[i].length; j++) {
                first = array[i][j];
                if (first > 0) {
                    j1 = j;
                    for (int k = j1 + 1; k < array[i].length; k++) {
                        second = array[i][k];
                        if (second > 0) {
                            j2 = k;
                            break outer;
                        }

                    }
                } else {
                    first = 0;
                    second = 0;
                }
            }

            for (int l = j1 + 1; l < j2; l++) {
                if (first == 0 || second == 0) {
                    break;
                }
                sum += array[i][l];
            }


            System.out.println(first + " " + second);
            System.out.println("Сумма " + i + " строки равна " + sum);

        }
        return sum;
    }
}




