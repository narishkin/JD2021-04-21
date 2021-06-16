package by.it.nikitko.jd01_15;

import java.io.*;
import java.util.Random;

public class TaskA {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        fillMatrix(matrix);
        String fileName= PathCreator.getPath(TaskA.class)+"matrix.txt";
        printMatrixTxt(matrix,fileName);
        readToConsole(fileName);
    }

    private static void readToConsole( String fileName) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String line = fileReader.readLine();
            while (line!=null) {
                System.out.println(line);
                line = fileReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
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
               row[i] = -15+ RANDOM.nextInt(31);
            }
        }
    }

}
/*

 */