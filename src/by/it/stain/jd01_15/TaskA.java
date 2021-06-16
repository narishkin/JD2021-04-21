package by.it.stain.jd01_15;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import  java.util.Random;

public class TaskA {
    private static final Random random = new Random();
    public static final String MATRIX_TXT= "matrix.txt";

    public static void main(String[] args) {
        int[][]array= new int[6][4];
        fillArray(array);
        String fileName = PatchCreator.getFileName(TaskA.class,MATRIX_TXT);
        printMatrixText(array,fileName);
        readToConsole(fileName);







            

    }

    private static void readToConsole(String fileName) {
        try {
            Files.lines(Paths.get(fileName)).forEach(System.out::println);

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private static void printMatrixText(int[][] array, String fileName) {
        try(PrintWriter printWriter = new PrintWriter(fileName)){
            for (int[] row : array) {
                for (int element : row) {
                    printWriter.printf("%3d ",element);

                }printWriter.println();


            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void fillArray(int[][] array) {
        for (int[] row : array) {
            for (int i = 0; i < row.length; i++) {
                row[i]=-15+random.nextInt(31);
            }

        }
    }
}
