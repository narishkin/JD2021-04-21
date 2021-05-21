package by.it.nikitko.jd01_05;

import static java.lang.Math.ceil;

public class Helper {

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max + 1 - min)) + min);
    }

    public static void calculateGeometricMeanOfNumbers(double[] array) {
        double geometricMeanOfNumbers = 1;
        for (double v : array) {
            geometricMeanOfNumbers = geometricMeanOfNumbers * v;
        }
        geometricMeanOfNumbers = Math.pow(geometricMeanOfNumbers, (1.0 / array.length));
        System.out.printf("Geometric mean of numbers array B = %4.2f %n", geometricMeanOfNumbers);

    }


    public static void printIntArray(int[] arr, String arrayName, int columnCount) {
        int rowCount = (int) ceil((double) arr.length / (double) columnCount);
        System.out.println("Array A, index to rows");
        System.out.println("╔═════════════╦═════════════╦═════════════╦═════════════╦═════════════╗");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("║ %s[% -3d]=%-5d", arrayName, i, arr[i]);
            if ((i + 1) % columnCount == 0 || (i + 1) == arr.length) {
                System.out.print("║");
                System.out.println();
                rowCount--;
                if (rowCount != 0) {
                    System.out.println("╠═════════════╬═════════════╬═════════════╬═════════════╬═════════════╣");
                }
            }
        }
        System.out.println("╚═════════════╩═════════════╩═════════════╩═════════════╩═════════════╝");
    }
}
