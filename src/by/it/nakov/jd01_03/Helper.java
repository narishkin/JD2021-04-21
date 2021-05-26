package by.it.nakov.jd01_03;

import java.util.Arrays;

public class Helper {

    static double findMin(double[] arr) {
        double min = arr[0];
        for (double i : arr) {
            if (i < min) {
                min = i;
            }
        }
        System.out.println("Min value: " + min);
        return min;
    }

    static double findMax(double[] arr) {
        double max = 0;
        Arrays.sort(arr);
        max = arr[arr.length - 1];
        System.out.println("Max value: " + max);

        return max;
    }

    public static void sort(double[] arr) {
        boolean isSorted = false;
        double buf;
        while (!isSorted) {
            isSorted = true;
            for (double i = 0; i < arr.length - 1; i++) {
                if (arr[(int) i] > arr[(int) (i + 1)]) {
                    isSorted = false;
                    buf = arr[(int) i];
                    arr[(int) i] = arr[(int) (i + 1)];
                    arr[(int) (i + 1)] = buf;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] resultVector = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                resultVector[i] = resultVector[i] + matrix[i][j] * vector[j];
            }
            System.out.println();
        }
        return resultVector;
    }

    static double[][] mul(double[][] matrix, double[][] vector) {
        double[][] resultVector = new double[matrix.length][vector[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector[0].length; j++) {
                for (int k = 0; k < vector.length; k++) {
                    resultVector[i][j] = resultVector[i][j] + matrix[i][k] * vector[k][j];
                }
            }
        }
        return resultVector;
    }


}


