package by.it.marusich.jd01_03;

import java.util.Arrays;

public class Helper {
    static double findMin(double[] arr) {
        double min = arr[0];
        for (double element : arr) {
            if (min > element) {
                min = element;

            }
        }
        System.out.println(min);
        return min;
    }

    static double findMax(double[] arr) {
        double max = arr[0];
        for (double element : arr) {
            if (max < element) {
                max = element;

            }
        }
        System.out.println(max);
        return max;
    }

    static void sort(double[] arr) {
        Arrays.sort(arr);
        double max = arr[0];
        for (double element : arr) {
            if (max > element)
                max = element;
        }
        for (double i = 0; i < arr.length; i++) {
            System.out.print(i + " ");
        }
        //for (int i = 0; i < ; i++) {

        }
    }
