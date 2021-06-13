package by.it.nikitko.jd01_15;

import java.io.*;

public class TaskB {


    private static final String TXT_TASK_B = "TaskB.txt";
    private static final char NEL = '\n';
    private static final char SLASH_R = '/';
    private static final char ASTERISK = '*';

    public static void main(String[] args) {

        String fileName = PathCreator.getPath(TaskB.class) + "TaskB.java";
        StringBuilder program = refactoringJavaFile(fileName);
        print(program);
    }
    /*comment this line
    comment this line
    comment this line
    comment this line
    comment this line*/


    /**
     * Javadoc comment
     * javadoc comment
     * Javadoc comment
     */

    private static StringBuilder refactoringJavaFile(String fileName) { //first comment
        StringBuilder program = new StringBuilder();                    //second comment
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            int currSymbol = fileReader.read();
            while (currSymbol != -1) {
                char currentChar = (char) currSymbol;
                if (currentChar == SLASH_R) {
                    char nextChar = (char) fileReader.read();
                    switch (nextChar) {
                        case (ASTERISK):
                            while (nextChar != SLASH_R) {
                                nextChar = (char) fileReader.read();
                            }
                            nextChar = (char) fileReader.read();
                            break;
                        case (SLASH_R):
                            while (nextChar != NEL) {
                                nextChar = (char) fileReader.read();
                            }
                            break;
                        default:program.append(currentChar);
                    }
                    currentChar = nextChar;
                }
                program.append(currentChar);
                currSymbol = fileReader.read();
            }
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return program;
    }
    /*
    comment this line
    comment this line
    comment this line
    comment this line
    comment this line
    */

    private static void print(StringBuilder program) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(PathCreator.getPath(TaskB.class) + TXT_TASK_B))) {
            System.out.println(program);
            printWriter.println(program);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
