package by.it.nakov.jd01_04;

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
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;
                    buf = (int) arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buf;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

     static double[] mul(double[][] matrix, double[] vector) {
         vector = new double[]{1.0, 0.0, 1.0, 1.0};
         double[] resultVector = new double[7];
         matrix = new double[][]{{1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0},
                                 {1.0, 3.0, 0.0, 0.0, 1.0, 1.0, 0.0},
                                 {3.0, 5.0, 0.0, 0.0, 4.0, 3.0, 0.0},
                                 {2.0, 0.0, 4.0, 0.0, 2.0, 1.0, 4.0}};

        System.out.println("выводим вектор который будем умножать на матрицу: ");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]);
        }
        System.out.println();
        System.out.println("выводим матрицу: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 4; i++) {
                resultVector[j] += matrix[i][j] * vector[i];
            }
        }
        System.out.println("------------");
        for (int i = 0; i < resultVector.length; i++) {
            System.out.print(resultVector[i]);
        }
        return resultVector;
    }
}


