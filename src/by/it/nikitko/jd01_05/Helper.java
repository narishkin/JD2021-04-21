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

        System.out.println("Array A, index to rows");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-5d", arrayName, i, arr[i]);
            if ((i + 1) % columnCount == 0 || (i + 1) == arr.length) {

                System.out.println();
            }
        }

    }

    public static void printIntArrayIndexToRowsWithBorders(int[] arr, String arrayName, int columnCount) {
        int rowCount = (int) ceil((double) arr.length / (double) columnCount);
        int ceilCountInTable = rowCount * columnCount;
        int emtyCeilCount = ceilCountInTable - arr.length;
        System.out.println("Array A, index to rows");
        System.out.print("╔═════════════╦");
        for (int i = 1; i < columnCount - 1; i++) {
            System.out.print("═════════════╦");
        }
        System.out.println("═════════════╗");

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("║ %s[% -3d]=%-5d", arrayName, i, arr[i]);
            if ((i + 1) % columnCount == 0 || (i + 1) == arr.length) {
                System.out.print("║");
                if (i != arr.length - 1) {
                    System.out.println();
                }
                rowCount--;

                if (rowCount != 0) {
                    System.out.print("╠═════════════╬");
                    for (int i1 = 1; i1 < columnCount - 1; i1++) {
                        System.out.print("═════════════╬");
                    }
                    System.out.println("═════════════╣");

                }
            }
        }
        for (int i2 = 0; i2 < emtyCeilCount; i2++) {
            System.out.print("             ║");
        }
        System.out.println();
        System.out.print("╚═════════════╩");
        for (int i = 1; i < columnCount - 1; i++) {
            System.out.print("═════════════╩");
        }
        System.out.println("═════════════╝");
    }


    public static void printIntArrayIndexToColumnsWithBorders(int[] arr, String arrayName, int columnCount) {
        int rowCount = (int) ceil((double) arr.length / (double) columnCount);
        boolean flagEmptyCeil = false;
        System.out.println("Array B, index to columns");
        System.out.println("╔═══════════╦═══════════╗");
        for (int i = 0; i < rowCount; i++) {
            if (i != 0) {
                System.out.println("╠═══════════╬═══════════╣");
            }
            if (i + rowCount >= arr.length) {
                System.out.printf("║%s[% -3d]=%3d ║           ║\n", arrayName, i, arr[i]);
                System.out.println("╚═══════════╩═══════════╝");
                flagEmptyCeil = true;
                break;
            }
            System.out.printf("║%s[% -3d]=%3d ║%s[%3d]=%3d ║\n", arrayName, i, arr[i], arrayName, i + rowCount, arr[i + rowCount]);
        }
        if (!flagEmptyCeil) {
            System.out.println("╚═══════════╩═══════════╝");
        }
    }
}
