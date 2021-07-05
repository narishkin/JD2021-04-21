package by.it.vencerev.jd01_15;

import java.io.*;
import java.util.Random;

import static by.it.vencerev.jd01_15.PathCreator.getPath;

/*public class TaskA {
    private static Random random = new Random();
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        fillMatrix(matrix);
        String fileName = getPath(TaskA.class) + "matrix.txt";
        printMatrixTXT(matrix, fileName);
        readToConsole(fileName);
        readToConsole(fileName);
    }

    private static void printMatrixTXT(int[][] matrix, String fileName) {
    }

    private static void readToConsole(String fileName) {
    }

    private static void fillMatrix(int[][] matrix) {
    }

    private static void readToConsole ( int[][] matrix, String fileName) throws IOException {
        try ( FileReader fileReader=new FileReader(fileName)){
            for (int[] row : matrix){
                for (int element : row){
                    System.out.printf("%3d",element);
                }
                System.out.println();
                private static void readToConsole ( String, fileName) {
                    try (BufferedReader fileReader =new BufferedReader(new FileReader(fileName))){
                        String line=fileReader.readLine();
                        while (line!=null){
                            System.out.println(line);
                            line=fileReader.readLine();
                        }

                    } catch (IOException e) {
                        new RuntimeException(e);
                        e.printStackTrace();
                    }
                }
                private static void printMatrixTXT(int[][] matrix, String fileName) {

                    try ( PrintWriter printWriter= new PrintWriter(fileName)){
                        for (int[] row : matrix)
                            for (int element : row) {
                                private static void printMatrixTXT ( int[][] matrix, String fileName){
                                    private static void fillMatrix ( int[][] matrix){
                                        for (int[] row : matrix) {
                                            for (int i = 0; i < row.length; i++) {
                                                row[i] = -15 + random.nextInt(31);
                                                row[i] = -15 + RANDOM.nextInt(31);

                                            }
                                        }
                                    }

                                }
                            }

 */