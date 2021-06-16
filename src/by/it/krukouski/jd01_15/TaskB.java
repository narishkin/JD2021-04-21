package by.it.krukouski.jd01_15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class TaskB {

    private static final String TEXT_FILE = "TaskB.txt";
    private static final String JAVA_FILE = "TaskB.java";

    public static void main(String[] args) {
        // comment one
        // comment two
        /* comment three
         comment four
        */
        /*comment five
        comment six
         */
        /**
         * Method is not found
         */
        String javaFile = PathCreator.getFileName(TaskB.class, JAVA_FILE);
        String textFile = PathCreator.getFileName(TaskB.class, TEXT_FILE);
        StringBuilder sb = new StringBuilder();
        javaRead(javaFile, sb);

        printToTextFile(textFile, sb);


    }

    private static void javaRead(String javaFile, StringBuilder sb) {
        try {

            Object[] lines = Files
                    .lines(Path.of(javaFile))
                    .toArray();
            for (Object line : lines) {
                String s = line.toString().trim();
                if (!s.startsWith("//") &&
                        !s.startsWith("/*") &&
                        !s.startsWith("*/") &&
                        !s.startsWith("/**") &&
                        !s.startsWith("*")) {
                    sb.append(s).append("\n");
                }
            }
            System.out.println("sb=" + sb);

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private static void printToTextFile(String textFile, StringBuilder sb) {
        try (PrintWriter printWriter = new PrintWriter(textFile)) {
            printWriter.println(sb);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
