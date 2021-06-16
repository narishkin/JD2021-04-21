package by.it.naryshkin.jd01_15;

import java.io.*;

/**
 * TaskB Class, this is the training class.
 */
public class TaskB {
    public static StringBuilder readCode = new StringBuilder();
    public static final String writeFileName = "TaskB.txt";
    public static final String readClassName = "TaskB.java";

    /*
   The main method ->
    */

    public static void main(String[] args) {
        /*
        Creating a program for reading different comments inside TaskB class.
        */
        String readPath = PathCreator.getFileName(TaskB.class, readClassName);
        String writePath = PathCreator.getFileName(TaskB.class, writeFileName);
        readingProgramText(readPath);
        String code = readCode.toString();
        StringBuilder removedCommentsText = programCommentsRemoving(code);
        writingProgramText(removedCommentsText, writePath);
        System.out.println(code);
    }
    // Reading the text of this program.
    private static void readingProgramText(String readPath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(readPath))) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {  //inside try block
                readCode.append(s).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder programCommentsRemoving(String codeText) {
        StringBuilder finalCode = new StringBuilder();
        State statePointer = State.OUTSIDE_COMMENT_STATE;
        for (int i = 0; i < codeText.length(); i++) {
            char ch = codeText.charAt(i);
            switch (statePointer) {
                case OUTSIDE_COMMENT_STATE:
                    if (ch == '/') {
                        statePointer = State.POSSIBLE_FIRST_SLASH;
                    } else {
                        finalCode.append(ch);
                    }
                    break;

                case POSSIBLE_FIRST_SLASH:
                    if (ch == '/') {
                        statePointer = State.INSIDE_LINE_COMMENT;
                    } else if (ch == '*') {
                        statePointer = State.INSIDE_MULTILINE_COMMENT;
                    } else{
                        finalCode.append('/').append(ch);
                        statePointer = State.OUTSIDE_COMMENT_STATE;
                    }
                    break;

                case INSIDE_LINE_COMMENT:
                    if (ch == '\n') {
                        statePointer = State.OUTSIDE_COMMENT_STATE;
                        finalCode.append('\n');
                        break;
                    }

                case INSIDE_MULTILINE_COMMENT:
                    if (ch == '*') {
                        statePointer = State.POSSIBLE_END_STAR;
                    }
                    break;

                case POSSIBLE_END_STAR:
                    if (ch == '/') {
                        statePointer = State.OUTSIDE_COMMENT_STATE;
                    }
                    break;
            }

        }
        return finalCode;
    }

    private static void writingProgramText(StringBuilder removedCommentsText, String writePath) {
        try (FileWriter fw = new FileWriter(writePath)) {
            fw.write(String.valueOf(removedCommentsText));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

enum State {
    OUTSIDE_COMMENT_STATE,
    POSSIBLE_FIRST_SLASH,
    INSIDE_LINE_COMMENT,
    INSIDE_MULTILINE_COMMENT,
    POSSIBLE_END_STAR,
}