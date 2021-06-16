package by.it.karpiuk.jd01_15;

import java.util.Random;
public class TaskA {

    public static final Random random = new Random();

    public static void main(String[] args) {
        int[][] matrix=new int[6][4];
        fill(matrix);
    }

    private static void fill(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] row=matrix[i];
            for (int j = 0; i < row.length; j++) {
                row[i]= -15+random.nextInt(31);


            }

        }
    }
}
