package by.it.zhurauleu.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = step1(n);
        step2(matrix);
        step3(matrix);
    }

    static int[][] step1(int n) {

        Random rand = new Random();
        int[][] arr = new int[n][n];
        int min = -n;
        int max = n;

        int minCount;
        int maxCount;

        do {
            minCount = 0;
            maxCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[j][i] = rand.nextInt(n * 2 + 1) - n;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == max) {
                        maxCount++;
                    } else if (arr[i][j] == min) {
                        minCount++;
                    }
                }
            }
        } while (maxCount == 0 || minCount == 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return arr;
    }


    static int step2(int[][] arr) {
        int positiveNumberCounter = 0;
        int[] twoFirstPositiveNumberIndex = new int[2];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) {
                    twoFirstPositiveNumberIndex[positiveNumberCounter] = j;
                    positiveNumberCounter++;
                }
                if (positiveNumberCounter == 2) {
                    for (int k = twoFirstPositiveNumberIndex[0] + 1; k < twoFirstPositiveNumberIndex[1]; k++) {
                        sum += arr[i][k];
                    }
                    break;
                }
            }
            positiveNumberCounter = 0;
        }
        System.out.println("сумма: " + sum + "\n");
        return sum;
    }

    static int[][] step3(int[][] arr) {
        int max = arr[0][0];
        int[] deletedRowsIndex = new int[arr[0].length];
        int[] deletedColumnsIndex = new int[arr.length];
        int deletedRowsCounter = 0;
        int deletedColumnsCounter = 0;
        int r = 0;
        int c = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == max) {
                    deletedRowsIndex[i] = 1;
                    deletedColumnsIndex[j] = 1;
                }
            }
        }

        for (int i = 0; i < deletedRowsIndex.length; i++) {
            if (deletedRowsIndex[i] == 1) {
                deletedRowsCounter++;
            }
        }

        for (int i = 0; i < deletedColumnsIndex.length; i++) {
            if (deletedColumnsIndex[i] == 1) {
                deletedColumnsCounter++;
            }
        }
        int[][] resultMatrix = new int[arr[0].length - deletedRowsCounter][arr.length - deletedColumnsCounter];

        for (int i = 0; i < arr.length; i++) {
            if (deletedRowsIndex[i] == 0) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (deletedColumnsIndex[j] == 0) {
                        resultMatrix[r][c] = arr[i][j];
                        c++;
                    }
                }
                r++;
                c = 0;
            }
        }

        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
        return resultMatrix;
    }

}
