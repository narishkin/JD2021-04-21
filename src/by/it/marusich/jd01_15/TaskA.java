package by.it.marusich.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class TaskA {

    private static final Random RANDOM = new Random();
    private static final String TEXT_FILE = "matrix.txt";

    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        fillMatrix(matrix);
        String text = PathCreator.getFileName(TaskA.class, TEXT_FILE);
        writeFile(text, matrix);
        //readFile(text);
        readFile2(text);

    }

    private static void readFile2(String text) {
        try {
            Files
                    .lines(Path.of(text))
                    .forEach(System.out::println);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private static void readFile(String text) {
        String string;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(text))
        ) {
            while ((string = bufferedReader.readLine()) != null) {
                System.out.println(string);
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private static void fillMatrix(int[][] matrix) {
        for (int[] array : matrix) {
            for (int i = 0; i < array.length; i++) {
                array[i] = -15 + RANDOM.nextInt(31);
            }
        }
    }

    private static void writeFile(String text, int[][] matrix) {
        try (PrintWriter printWriter = new PrintWriter(text)
        ) {
            for (int[] array : matrix) {
                for (int j : array) {
                    printWriter.printf("%3d ", j);
                }
                printWriter.println();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
