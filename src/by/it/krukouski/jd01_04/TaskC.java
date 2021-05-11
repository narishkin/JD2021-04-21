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
        //double firstIndex = array[0];
        //double lastIndex = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        System.out.println();
        mergeSort(array);
        InOut.printArray(array, "V", 4);


    }

    static void mergeSort(double[] array) {
        int left = 0;
        int right = array.length;
        if (right <= left) {
            return;
        }
        int middle = (right + left) / 2;
        double[] arrayLeft = new double[middle];
        double[] arrayRight = new double[right - middle];
        mergeSort(arrayLeft);
        mergeSort(arrayRight);
        merge(arrayLeft, arrayRight);

    }

    /*static void mergeSort(double[] array, int left, int right) {
        if (right <= left) {
            return;
        }
        int middle = (left + right) / 2;
        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);
        merge(array, left, middle, right);
    }
*/
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

}

