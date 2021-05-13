package by.it.sapazhkou.jd01_02;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        step1(array);
        step2(array);
        step3(array);
    }

    private static void step1(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int element : array) {
            if (min > element) {
                min = element;
            }
            if (max < element) {
                max = element;
            }
        }
        System.out.print(min +" "+max);
        System.out.println();
    }

    private static void step2(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        double avg = sum / array.length;
        for (int element : array){
            if (avg>element) {
                System.out.println(element);
            }
        }

    }

    private static void step3(int[] array) {
        int[] minIndex = new int[10];
        int min = array[0];
        int j=0;
        for (int i = 0; i < array.length; i++) {
            if (min>array[i]){
                min = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if(min == array[i]){
                minIndex[j] = i;
                j=j+1;
            }
        }
        for (int i = j-1; i >= 0 ; i--) {
            System.out.print(minIndex[i]+" ");
        }
        System.out.println();
    }
}
