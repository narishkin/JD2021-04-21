package by.it.sapazhkou.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        int array[][];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        array = step1(n);
        step2(array);
        step3(array);
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
                for (int j = 0; j < array.length; j++) {
                    int rnd = (int) (Math.random() * size) + minBorder;
                    array[i][j] = rnd;
                    if (rnd == minBorder) {
                        minFind = true;
                    } else if (rnd == maxBorder) {
                        maxFind = true;
                    }
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
        return array;
    }

    static int step2(int array[][]) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            int sumString = 0;
            boolean positiveFind = false;
            for (int j = 0; j < array.length; j++) {
                if ((array[i][j] > 0) && (sumString == 0) && !positiveFind) {
                    positiveFind = true;
                } else if ((array[i][j] > 0) && positiveFind) {
                    positiveFind = true;
                    break;
                } else if ((array[i][j] <= 0) && positiveFind) {
                    sumString = sumString + array[i][j];
                    positiveFind = true;
                }
            }
            sum = sum + sumString;
        }
        return sum;
    }

    public static int[][] step3(int[][] array) {

        int maxValue = array[0][0];

        int k = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (maxValue < array[i][j]) {
                    maxValue = array[i][j];
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (maxValue == array[i][j]) {
                    k = k + 1;
                }
            }
        }
        int[] tmpIndexString = new int[k];
        int[] tmpIndexColumn = new int[k];

        k = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (maxValue == array[i][j]) {
                    tmpIndexString[k] = i;
                    tmpIndexColumn[k] = j;
                    k = k + 1;
                }
            }
        }
        Arrays.sort(tmpIndexColumn);

        int contNewString = 1;
        for (int i = 1; i < tmpIndexString.length; i++) {
            if (tmpIndexString[i] != tmpIndexString[i - 1]) {
                contNewString++;
            }
        }
        int[] indexString = new int[contNewString];
        int a = 0;
        indexString[a] = tmpIndexString[0];
        for (int i = 1; i < tmpIndexString.length; i++) {
            if (tmpIndexString[i] != tmpIndexString[i - 1]) {
                a = a + 1;
                indexString[a] = tmpIndexString[i];
            }
        }
        int contNewColumn = 1;
        for (int i = 1; i < tmpIndexColumn.length; i++) {
            if (tmpIndexColumn[i] != tmpIndexColumn[i - 1]) {
                contNewColumn++;
            }
        }
        int[] indexColumn = new int[contNewColumn];
        int b = 0;
        indexColumn[b] = tmpIndexColumn[0];
        for (int i = 1; i < tmpIndexColumn.length; i++) {
            if (tmpIndexColumn[i] != tmpIndexColumn[i - 1]) {
                b = b + 1;
                indexColumn[b] = tmpIndexColumn[i];
            }
        }
        int iRes = 0;
        int jRes = 0;
        int[][] resArray = new int[(array.length-indexString.length)][(array.length-indexColumn.length)];

        for (int i = 0; i < array.length; i++) {
            boolean stopSrt = false;
            for (int iSrt = 0; iSrt < indexString.length; iSrt++) {
                if (i == indexString[iSrt]) {
                    stopSrt = true;
                }
            }
            if (stopSrt) {

            } else {


                for (int j = 0; j < array.length; j++) {
                    boolean stopCln = false;
                    for (int jClm = 0; jClm < indexColumn.length; jClm++) {
                        if (j == indexColumn[jClm]) {
                            stopCln = true;
                        }
                    }
                    if (stopCln) {

                    } else {

                    System.arraycopy(array[i],j,resArray[iRes],jRes,1);
                         jRes++;
                    }
                }
                iRes++;
                jRes = 0;
            }
       }
    return resArray;
    }
}