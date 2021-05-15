package by.it.karpovich.jd01_02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static int n;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int array[][];
        array = step1(n);
        step2(array);

    }

    static int step2(int array[][]) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            int sumLine= 0;
            boolean positiveFound = false;
            for (int j = 0; j < array.length; j++) {
                if ((array[i][j] > 0) && (sumLine == 0) && !positiveFound) {
                    positiveFound = true;
                } else if ((array[i][j] > 0) && positiveFound) {
                    positiveFound = true;
                    break;
                } else if ((array[i][j] <= 0) && positiveFound) {
                    sumLine = sumLine + array[i][j];
                    positiveFound = true;
                }
            }
            sum = sum + sumLine;
        }
        return sum;
    }

    private static int[][] step1(int n) {
        int[][] array = new int[n][n];
        int min = -1 * n;
        int max = 1 * n;
        int diff = max - min;
        Random random = new Random();
        boolean findMin = false;
        boolean findMax = false;
        while (findMax != true && findMin != true) {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = random.nextInt(diff + 1) + min;
                    if (array[i][j] == min) {
                        findMin = true;
                    }
                    if (array[i][j] == max) {
                        findMax = true;
                    }
                }
            }
            Arrays.deepToString(array);
        }
        return array;
    }
}


