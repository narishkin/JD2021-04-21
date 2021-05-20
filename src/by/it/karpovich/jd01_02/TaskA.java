package by.it.karpovich.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scan.nextInt();
        }
       step3(mas);
       step2(mas);
       step1(mas);
        //System.out.println(Arrays.toString(mas));
    }

    static void step3(int[] mas) {
        int min = mas[0];
        for (int i = 0; i < mas.length ; i++) {
            if (mas[i] <= min) {
                min = mas[i];
            }
        }
        for (int i = mas.length - 1; i >= 0; i--){
            if (mas[i] == min){
                System.out.print(i + " ");
            }
        }
    }

     static void step1(int[] mas) {
        int max = mas[0];
        int min = mas[0];
        for (int ma : mas) {
            if (ma < min) {
                min = ma;
            }
            if (ma > max) {
                max = ma;
            }
        }
       System.out.println(min + " " + max);

    }


    static void step2(int[] mas) {
        double sum = 0;
        for (int j : mas) {
            sum += j;
        }
        double average = sum / mas.length;
        System.out.println(average);
        for (int ma : mas) {
            if (ma < average) {
                System.out.println(ma + " ");
            }
        }
    }


}
