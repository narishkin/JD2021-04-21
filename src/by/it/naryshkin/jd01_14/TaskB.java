package by.it.naryshkin.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private final String textFilename = dir(TaskB.class) + "Poem.txt";
    private final String writeFilename = dir(TaskB.class) + "resultTaskB.txt";
    private int wordCounter = 0;
    private int punctuationMarksCounter = 0;
    private String poem;
    private String finalString;

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {
        TaskB taskB = new TaskB();
        taskB.poem = taskB.readText();
        System.out.println(taskB.poem);
        taskB.finder(taskB.poem);
        taskB.textWriter();
    }

    private void textWriter() {
        PrintWriter PW = null;
        try {
            PW = new PrintWriter(new FileWriter(writeFilename));
            PW.printf(finalString);
            PW.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert PW != null;
            PW.close();
        }
    }

    private void finder(String poem) {
        String patternWords = "[А-ЯЁа-яё]+";
        String punctuationMarks = "[\\.,-:;.!]+";
        Pattern p1 = Pattern.compile(patternWords);
        Pattern p2 = Pattern.compile(punctuationMarks);
        Matcher m1 = p1.matcher(poem);
        while (m1.find()) {
            wordCounter++;
        }
        Matcher m2 = p2.matcher(poem);
        while (m2.find()) {
            punctuationMarksCounter++;
        }
        finalString = "words=" + wordCounter + ", " + "punctuation marks=" + punctuationMarksCounter;
        System.out.println(finalString);


    }

    private String readText() {
        String Poem = null;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader(textFilename);
            br = new BufferedReader(fr);
            while ((Poem = br.readLine()) != null) {
                sb.append(Poem);
                sb.append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br.readLine() != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
