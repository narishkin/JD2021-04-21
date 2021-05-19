package by.it.karpovich.jd01_03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Helper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] array = new double[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextDouble();
        }
        double[][] matrix = new double[10][10];
        Random random1 = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random1.nextInt(10) + 1;
            }
        }
        double[][] matrixLeft = new double[10][10];
        Random random2 = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random2.nextInt(10) + 1;
            }
        }
        double[][] matrixRight = new double[10][10];
        Random random3 = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random3.nextInt(10) + 1;
            }
        }
        findMin(array);
        findMax(array);
        mul(matrix, array);
        mul(matrixLeft, matrixRight);
        sort(array);
    }


    private static void sort(double[] arr) {
        Arrays.sort(arr);
        for (double v : arr) {
            System.out.println(v + " ");
        }
    }

    static double findMax(double[] arr) {
        double max = arr[0];
        for (double v : arr) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    static double findMin(double[] arr) {
        double min = arr[0];
        for (double v : arr) {
            if (v < min) {
                min = v;
            }
        }
        System.out.println(min);
        return min;
    }

    private static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] resultMatrix = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; ++i)
            for (int j = 0; j < matrixRight[0].length; ++j)
                for (int k = 0; k < matrixRight.length; ++k)
                    resultMatrix[i][j] += matrixLeft[i][k] * matrixRight[k][j];

        return resultMatrix;
    }

    private static double[] mul(double[][] matrix, double[] vector) {
        double[] resultArray = new double[matrix.length];
        for (int i = 0; i < resultArray.length; i++) {
            double sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j] * vector[j];
            }
            resultArray[i] = sum;
        }
        System.out.println(Arrays.deepToString(new double[][]{resultArray}));
        return resultArray;
    }
}


