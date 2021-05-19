package by.it.mogonov.jd01_04;

import java.util.Arrays;

public class Helper {

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



    static double findMax(double[] arr) {
        Arrays.sort(arr);
        double max = arr[arr.length - 1];
        System.out.println(max);
        return max;
    }


    static void sort(double[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
