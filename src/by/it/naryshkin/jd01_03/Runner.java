package by.it.naryshkin.jd01_03;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, "V", 5);
        System.out.println(Helper.findMin(array));
        System.out.println(Helper.findMax(array));
        Helper.sort(array);

        double[][] matrixA = new double[][]{
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11}};
        double[][] matrixB = new double[][]{
                {1, 5},
                {4, 6},
                {7, 7}};
        double[][] vector = new double[][]{{1}, {2}, {3}};
        InOut.printMatrix(Helper.mul(matrixA, vector));
        InOut.printMatrix(Helper.mul(matrixA, matrixB));


    }
}
