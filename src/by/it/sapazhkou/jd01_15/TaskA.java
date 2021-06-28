package by.it.sapazhkou.jd01_15;

import java.io.*;
import java.util.Random;

public class TaskA {

    public static Random random = new Random();
    public static final String FILE_RESULT = "matrix.txt";


    public static void main(String[] args) {

        int[][] matrix = new int[6][4];
        fillMatrix(matrix);
        String string = PathCreator.getPathName(TaskA.class, FILE_RESULT);
        printToFile(matrix, string);
        fileToConsole(string);
    }

    private static void fileToConsole(String string) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(string))) {
            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void printToFile(int[][] matrix, String string) {
        try (
                PrintWriter printWriter = new PrintWriter(string);
        ) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    printWriter.printf("%3d ", matrix[i][j]);
                }
                printWriter.printf("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void fillMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = -15 + random.nextInt(31);
            }
        }
    }
}
