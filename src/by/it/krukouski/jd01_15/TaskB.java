package by.it.krukouski.jd01_15;

import java.io.*;

public class TaskB {

    private static final String TEXT_FILE = "TaskB.txt";
    private static final String JAVA_FILE = "TaskB.java";
    public static StringBuilder stringBuilder = new StringBuilder();

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

        javaRead(javaFile);
        StringBuilder stringAfterRemoveComment = removeComment(TaskB.stringBuilder);
        System.out.println(stringAfterRemoveComment);

        printToTextFile(textFile, stringAfterRemoveComment);


    }

    private static StringBuilder removeComment(StringBuilder stringBuilder) {
        String string = stringBuilder.toString();
        StringBuilder sb = new StringBuilder();
        Condition condition = Condition.OUTSIDE_COMMENT;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            switch (condition) {
                case OUTSIDE_COMMENT:
                    if (ch == '/') {
                        condition = Condition.FIRST_SLASH;
                    } else {
                        sb.append(ch);
                    }
                    break;
                case FIRST_SLASH:
                    if (ch == '/') {
                        condition = Condition.LINE_COMMENT;
                    } else if (ch == '*') {
                        condition = Condition.MULTILINE_COMMENT;
                    } else {
                        sb.append('/').append(ch);
                        condition = Condition.OUTSIDE_COMMENT;
                    }
                    break;
                case LINE_COMMENT:
                    if (ch == '\n') {
                        sb.append('\n');
                        condition = Condition.OUTSIDE_COMMENT;
                        break;
                    }
                case MULTILINE_COMMENT:
                    if (ch == '*') {
                        condition = Condition.STAR;
                    }
                    break;
                case STAR:
                    if (ch == '/') {
                        condition = Condition.OUTSIDE_COMMENT;
                        break;
                    }
            }

        }
        return sb;


    }

    private static void javaRead(String javaFile) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(javaFile));
        ) {
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                stringBuilder.append(string).append("\n");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
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

enum Condition {
    OUTSIDE_COMMENT,
    FIRST_SLASH,
    LINE_COMMENT,
    MULTILINE_COMMENT,
    STAR,
}
