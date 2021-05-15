package by.it.krukouski.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String i = sc.nextLine();
        buildOneDimArray(i);
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstIndex = array[0];
        double lastIndex = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        System.out.println();
        mergeSort(array);
        InOut.printArray(array, "V", 4);
        System.out.println();
        System.out.printf("Index of first element=%1d\n", binarySearch(array,firstIndex));
        System.out.printf("Index of last element=%1d\n", binarySearch(array,lastIndex));


    }

    static void mergeSort(double[] array) {
        double[] mergeArray = mergeSort(array, 0, array.length - 1);
        System.arraycopy(mergeArray, 0, array, 0, array.length);
    }

    private static double[] mergeSort(double[] array, int left, int right) {
        if (array.length < 2) {
            return array;
        }

        double[] arrayLeft = new double[array.length / 2];
        System.arraycopy(array, left, arrayLeft, left, array.length / 2);
        double[] arrayRight = new double[array.length - array.length / 2];
        System.arraycopy(array, array.length / 2, arrayRight, 0, array.length - array.length / 2);
        arrayLeft = mergeSort(arrayLeft, 0, arrayLeft.length - 1);
        arrayRight = mergeSort(arrayRight, 0, arrayRight.length - 1);
        return merge(arrayLeft, arrayRight);

    }

    private static double[] merge(double[] arrayLeft, double[] arrayRight) {
        double[] arrayMerge = new double[arrayLeft.length + arrayRight.length];
        int indexLeft = 0;
        int indexRight = 0;
        for (int i = 0; i < arrayMerge.length; i++) {
            if (indexLeft == arrayLeft.length) {
                arrayMerge[i] = arrayRight[indexRight];
                indexRight++;
            } else if (indexRight == arrayRight.length) {
                arrayMerge[i] = arrayLeft[indexLeft];
                indexLeft++;
            } else if (arrayLeft[indexLeft] < arrayRight[indexRight]) {
                arrayMerge[i] = arrayLeft[indexLeft];
                indexLeft++;
            } else {
                arrayMerge[i] = arrayRight[indexRight];
                indexRight++;
            }

        }

        return arrayMerge;

    }

    static int binarySearch(double[] array, double value) {
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        while (firstIndex <= lastIndex) {
            int middle = (firstIndex + lastIndex) / 2;
            if (array[middle] == value) {
                return middle;
            } else if (array[middle] > value) {
                lastIndex = middle - 1;
            } else if (array[middle] < value) {
                firstIndex = middle + 1;
            }
        }
        return -1;
    }

}

