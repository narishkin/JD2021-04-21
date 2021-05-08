package by.it.nikitko.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);


    }


    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstItem = array[0];
        double lastItem = array[array.length - 1];
        int indexFirstItem;
        int indexLastItem;

        System.out.println("Unsorted array in 5 columns");
        InOut.printArray(array, "V", 5);

        mergeSort(array);
        System.out.println("Sorted array in 4 columns");
        InOut.printArray(array, "V", 4);

        indexFirstItem = binarySearch(array, firstItem);
        indexLastItem = binarySearch(array, lastItem);

        System.out.printf("Index of first element=%-2d%n" +
                "Index of last element=%-2d", indexFirstItem, indexLastItem);


    }

    static void mergeSort(double[] array) {
     sortArray(array);
    }



    public static double[] sortArray(double[] array) {
        if (array == null) {
            return null;
        }
        if (array.length < 2) {
            return array;
        }

        double[] arrayB = new double[array.length / 2];
        System.arraycopy(array, 0, arrayB, 0, array.length / 2);

        double[] arrayC = new double[array.length - arrayB.length];
        System.arraycopy(array, arrayB.length, arrayC, 0, array.length - arrayB.length);

        sortArray(arrayB);
        sortArray(arrayC);

        mergeArray(array, arrayB, arrayC);

        return array;
    }

    private static void mergeArray(double[] array, double[] arrayB, double[] arrayC) {

        int positionB = 0;
        int positionC = 0;

        for (int c = 0; c < array.length; c++) {
            if (positionB == arrayB.length) {
                array[c] = arrayC[positionC];
                positionC++;
            } else if (positionC == arrayC.length) {
                array[c] = arrayB[positionB];
                positionB++;
            } else if (arrayB[positionB] < arrayC[positionC]) {
                array[c] = arrayB[positionB];
                positionB++;
            } else {
                array[c] = arrayC[positionC];
                positionC++;
            }
        }
    }


    static int binarySearch(double[] array, double value) {
        int index = -1;
        int left = 0;
        int right = array.length;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == value) {
                index = middle;
                break;
            }
            if (array[middle] > value) {
                right = middle - 1;
            }
            if (array[middle] < value) {
                left = middle + 1;
            }
        }
        return index;
    }

}
