package by.it.sapazhkou.jd01_15;

import java.util.Random;

public class TaskA {

    public static Random random = new Random();
    public static final String FILE_RESULT = "matrix.txt";


    public static void main(String[] args) {

        int[][] matrix = new int[6][4];
        fillMatrix(matrix);
        String string = PathCreator.getPathName(TaskA.class, FILE_RESULT);


    }

    private static void fillMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = -15 + random.nextInt(31);
            }
        }
    }
}
