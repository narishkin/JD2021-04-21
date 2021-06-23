
package by.it.stain.jd01_02;


import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();


        int[][] matrix = step1(n);
        step2(matrix);
        step3(matrix);

    }


    static int[][] step1(int n) {
        int[][] matrix = new int[n][n];


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

                matrix[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
            }
        }


        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();

        }
        System.out.println();
        return matrix;
    }

     static int step2(int[][] arr) {
         int positiveFirst = 0;
         int[] positiveTwo = new int[2];
         int sum = 0;

         for (int[] ints : arr) {
             for (int j = 0; j < ints.length; j++) {
                 if (ints[j] > 0) {
                     positiveTwo[positiveFirst] = j;
                     positiveFirst++;
                 }
                 if (positiveFirst == 2) {
                     for (int k = positiveTwo[0] + 1; k < positiveTwo[1]; k++) {
                         sum += ints[k];
                     }
                     break;
                 }
             }
             positiveFirst = 0;
         }
         System.out.println("сумма: " + sum + "\n");
         return sum;


    }

    private static int[][] step3(int[][] arr) {

        int max = arr[0][0];
        int[] deleteRows = new int[arr[0].length];
        int[] deleteColumns = new int[arr.length];
        int deletedRowsCounter = 0;
        int deletedColumnsCounter = 0;
        int r = 0;
        int c = 0;

        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt > max) {
                    max = anInt;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == max) {
                    deleteRows[i] = 1;
                    deleteColumns[j] = 1;
                }
            }
        }

        for (int rowsIndex : deleteRows) {
            if (rowsIndex == 1) {
                deletedRowsCounter++;
            }
        }

        for (int columnsIndex : deleteColumns) {
            if (columnsIndex == 1) {
                deletedColumnsCounter++;
            }
        }
        int[][] resultMatrix = new int[arr[0].length - deletedRowsCounter][arr.length - deletedColumnsCounter];

        for (int i = 0; i < arr.length; i++) {
            if (deleteRows[i] == 0) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (deleteColumns[j] == 0) {
                        resultMatrix[r][c] = arr[i][j];
                        c++;
                    }
                }
                r++;
                c = 0;
            }
        }

        for (int[] matrix : resultMatrix) {
            for (int i : matrix) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        return resultMatrix;
    }

}


