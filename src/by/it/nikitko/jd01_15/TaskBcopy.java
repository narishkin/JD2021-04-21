package by.it.nikitko.jd01_15;

import java.io.*;

public class TaskBcopy {


    private static final String TXT_TASK_B = "TaskB.txt";
    private static final char NEL = '\n';
    private static final char SLASH_R = '/';
    private static final char ASTERISK = '*';

    public static void main(String[] args) {

        String fileName = PathCreator.getPath(TaskBcopy.class) + "TaskB.java";
        StringBuilder program = readToConsole(fileName);
        print(program);
    }
    /*comment this line
    comment this line
    comment this line
    comment this line
    comment this line*/


    /**Javadoc comment
    javadoc comment
    Javadoc comment*/

    private static StringBuilder readToConsole(String fileName) { //first comment
        StringBuilder program = new StringBuilder();              //second comment
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            int line = fileReader.read();
            while (line != -1) {
                char currentChar = (char) line;
                if (currentChar == SLASH_R) {
                    int lineNext = fileReader.read();
                    char nextChar = (char) lineNext;
                    if (nextChar == ASTERISK) {
                        while (nextChar != SLASH_R) {
                            lineNext = fileReader.read();
                            nextChar = (char) lineNext;
                        }
                    }
                    if (nextChar == SLASH_R) {
                        while (nextChar != NEL) {
                            lineNext = fileReader.read();
                            nextChar = (char) lineNext;
                        }
                    } else {
                        program.append(currentChar);
                    }
                    currentChar = nextChar;
                }
                program.append(currentChar);
                line = fileReader.read();
            }

        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return program;
    }
    /*comment this line
    comment this line
    comment this line
    comment this line
    comment this line*/

    private static void print(StringBuilder program) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(PathCreator.getPath(TaskBcopy.class) + TXT_TASK_B))) {
            System.out.println(program);
            printWriter.println(program);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
