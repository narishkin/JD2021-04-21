package by.it.krukouski.jd01_15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
        StringBuilder sb = new StringBuilder();
        try {
            String s = Files
                    .readString(Path.of(javaFile));

            sb.append(s);


        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        System.out.println(sb);


    }
}
