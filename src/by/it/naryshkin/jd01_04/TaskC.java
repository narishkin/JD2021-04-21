package by.it.naryshkin.jd01_04;

import java.util.Scanner;

public class TaskC {
    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        /*mergesorting*/
        mergeSort(array);

        InOut.printArray(array, "V", 4);
        System.out.println("Index of first element=" + binarySearch(array, first));
        System.out.println("Index of last element=" + binarySearch(array, last));

        for (int i = 0; i < array.length; i++) {
            if (array[i] == first) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == last) {
                System.out.println("Index of last element=" + i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }

    static void mergeSort(double[] array) {
        double[] arr;
        arr = splitArray(array);
        System.arraycopy(arr, 0, array, 0, arr.length);
    }

    private static double[] splitArray(double[] array) {
        if (array.length <= 1) {
            return array;
        }

        double[] arrayLeft = new double[array.length / 2];
        double[] arrayRight = new double[array.length - arrayLeft.length];
        System.arraycopy(array, 0, arrayLeft, 0, arrayLeft.length);
        System.arraycopy(array, arrayLeft.length, arrayRight, 0, arrayRight.length);
        arrayLeft = splitArray(arrayLeft);
        arrayRight = splitArray(arrayRight);
        return merge(arrayLeft, arrayRight);
    }

    private static double[] merge(double[] part1, double[] part2) {
        double[] mergedArray = new double[part1.length + part2.length];
        int pointerLeft = 0;
        int pointerRight = 0;
        int j, k;
        for (int i = 0; i < mergedArray.length; i++) {
            j = i - pointerLeft;
            k = i - pointerRight;
            if (j < part1.length && k < part2.length) {
                if (part1[j] <= part2[k]) {
                    mergedArray[i] = part1[j];
                    pointerRight++;
                } else {
                    mergedArray[i] = part2[k];
                    pointerLeft++;
                }
            }
            if (j >= part1.length) {
                mergedArray[i] = part2[k];
            } else if (k >= part2.length) {
                mergedArray[i] = part1[j];
            }
        }
        return mergedArray;
    }

    static int binarySearch(double[] array, double value) {
        int indexLeft = 0;
        int indexRight = array.length - 1;
        while (true) {
            int middle = (indexLeft + indexRight) / 2;
            if (array[indexRight] == value) {
                return indexRight;
            }
            if (array[indexLeft] == value) {
                return indexLeft;
            }
            if (array[middle] == value) {
                return middle;
            } else if (array[middle] > value) {
                indexRight = middle - 1;
            } else if (array[middle] < value) {
                indexLeft = middle + 1;
            }
        }
    }
}
