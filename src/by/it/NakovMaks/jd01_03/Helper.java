package by.it.NakovMaks.jd01_03;

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
}

