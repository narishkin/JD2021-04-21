package by.it.mogonov.jd01_15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class TaskA {

    public static final Random random = new Random();
    public static final String MATRIX_TXT = "matrix.txt";

    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        fill(matrix);
        String fileName = PathCreator.getFileName(TaskA.class, MATRIX_TXT);
        printMatrixText(matrix, fileName);
        readToConsole(fileName);
    }

    private static void readToConsole(String fileName) {
        try {
            Files
                    .lines(Paths.get(fileName))
                    .filter(line -> line.contains("-"))
                    .sorted()
                    .forEach(x -> System.out.println(x));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printMatrixText(int[][] matrix, String fileName) {
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            for (int[] row : matrix) {
                for (int element : row) {
                    printWriter.printf("%3d ", element);

                }
                printWriter.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void fill(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i] = -15 + random.nextInt(31);
            }
        }
    }
}



