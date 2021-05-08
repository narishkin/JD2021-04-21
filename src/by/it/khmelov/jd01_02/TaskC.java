package by.it.khmelov.jd01_02;

import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
    }

    static int[][] step3(int[][] array) {
        int max = getMax(array);
        boolean[] delCol = new boolean[array[0].length];
        boolean[] delRow = new boolean[array.length];
        fillBooleanArrays(array, max, delCol, delRow);
        int rowCount = getCount(delRow);
        int colCount = getCount(delCol);
        return fillResultArray(array, delCol, delRow, rowCount, colCount);

    }

    private static int[][] fillResultArray(int[][] array, boolean[] delCol, boolean[] delRow, int rowCount, int colCount) {
        int[][] resultArray = new int[rowCount][colCount];
        for (int i = 0, ir = 0; i < array.length; i++) {
            if (!delRow[i]) {
                for (int j = 0, jr = 0; j < array[i].length; j++) {
                    if (!delCol[j]) {
                        resultArray[ir][jr++] = array[i][j];
                    }
                }
                ir++;
            }
        }
        return resultArray;
    }

    private static int getCount(boolean[] delRow) {
        int rowCount = 0;
        for (boolean delCurrentRow : delRow) {
            if (!delCurrentRow) {
                rowCount++;
            }
        }
        return rowCount;
    }

    static void fillBooleanArrays(int[][] array, int max, boolean[] delCol, boolean[] delRow) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == max) {
                    delCol[j] = true;
                    delRow[i] = true;
                }
            }
        }
    }

    private static int getMax(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int[] row : array) {
            for (int e : row) {
                if (e > max) {
                    max = e;
                }
            }
        }
        return max;
    }
}
