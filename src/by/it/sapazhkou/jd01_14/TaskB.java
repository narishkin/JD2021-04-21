package by.it.sapazhkou.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TaskB {

    public static void main(String[] args) {

        String root = System.getProperty("user.dir");
        Class<TaskB> aClass = TaskB.class;
        String pathProject = aClass.getName().
                replace(aClass.getSimpleName(), "").
                replace(".", File.separator);
        String pathFile = root + File.separator + "src" + File.separator + pathProject + "Poem.txt";
        String pathFileResult = root + File.separator + "src" + File.separator + pathProject + "resultTaskB.txt";


        File poem = new File(pathFile);
        Pattern patternWords = Pattern.compile("[\\s\\:\\/\\;\\.\\,\\—\\-\\?\\!\\\"]+");
        Pattern patternMarks = Pattern.compile("[\\:\\/\\;\\.\\,\\—\\-\\?\\!\\\"]+");
        Scanner scanner = null;
        try {
            scanner = new Scanner(poem);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int words = 0;
        int marks = 0;
        scanner.useDelimiter(patternWords);
        while (scanner.hasNext()) {
            scanner.next();
            words = words + 1;
        }
        scanner.close();
        Scanner scanner1 = null;
        try {
            scanner1 = new Scanner(poem);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner1.useDelimiter(patternMarks);
        while (scanner1.hasNext()) {
            scanner1.next();
            marks = marks + 1;
        }
        scanner1.close();
        System.out.printf("words=%s, punctuation marks=%s",words,marks);
// to result
        try (
                PrintWriter printWriter = new PrintWriter(pathFileResult);
        ) {
            printWriter.printf("words=%s, punctuation marks=%s",words,marks);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
