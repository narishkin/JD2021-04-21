package by.it.nikitko.jd01_15;

import java.io.*;

public class TaskB {
    public static void main(String[] args) {


        String fileName = PathCreator.getPath(TaskB.class) + "TaskB.java";
        readToConsole(fileName);
    }

    private static void readToConsole(String fileName) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            int line = fileReader.read();
            while (line!=-1) {
                char a = (char) line;
                System.out.println(a);
                line = fileReader.read();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }



    /*  private static void readToConsole(String fileName) {
        try (BufferedInputStream fileReader = new BufferedInputStream(new FileInputStream(fileName))) {
            int line = fileReader.read();
            while (fileReader.available()>0) {
                System.out.println(line);
                line = fileReader.read();
            }
        } catch (IOException e) {
            new RuntimeException(e);
        }
    }*/
}}
