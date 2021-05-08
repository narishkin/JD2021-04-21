package by.it.karpiuk.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();

        }
        step1();
   //     step2(array);
     //   step3(a, b, c);

    }
    static void step1(){
        int[][] matrix = new int[5][5];
        int i,j;
        int n=1;
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                matrix[i][j]=n;
                n++;
            }
            System.out.println(matrix);
            
        }
    }
}
