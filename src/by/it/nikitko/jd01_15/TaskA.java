package by.it.nikitko.jd01_15;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class TaskA {

    private static Random random = new Random();

    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        fillMatrix(matrix);
        String fileName= PathCreator.getPath(TaskA.class)+"matrix.txt";
        printMatrixTxt(matrix,fileName);
        readToConsole(matrix,fileName);
    }

    private static void readToConsole(int[][] matrix, String fileName) {
        try (FileReader fileReader = new FileReader(fileName)) {
            for (int[] row : matrix) {
                for (int element : row) {
                    System.out.printf("%3d ",element);
                }
                System.out.println();;
            }

        } catch (IOException e) {
           new RuntimeException(e);
        }
    }

    private static void printMatrixTxt(int[][] matrix, String fileName) {
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            for (int[] row : matrix) {
                for (int element : row) {
                    printWriter.printf("%3d ",element);
                }
                printWriter.println();
            }
        } catch (FileNotFoundException e) {
           new RuntimeException(e);
        }
    }


    private static void fillMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
               row[i] = -15+random.nextInt(31);
            }
        }
    }

}
/*

 */