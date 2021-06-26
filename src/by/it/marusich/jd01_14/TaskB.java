package by.it.marusich.jd01_14;

import java.io.*;

public class TaskB {

    static final String POEM = "Poem.txt";
    static final String TEXT_FILE = "resultTaskB.txt";
    static final String PATTERN = "[!.,-?;:]+";

    public static void main(String[] args) {
        String poemText = PathCreator.getFileName(TaskB.class, POEM);
        File f = new File(poemText);
        int words = 0;
        int marks = 0;
        words = getWords(f, words);
        marks = getMarks(f, marks);
        System.out.println("words=" + words);
        System.out.println("punctuation marks=" + marks);
        String textFile = PathCreator.getFileName(TaskB.class, TEXT_FILE);
        printTextFile(words, marks, textFile);


    }

    private static int getWords(File f, int words) {
        String string;
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(f))
        ) {
            while ((string = bufferedReader.readLine()) != null) {
                string = string.replaceAll(PATTERN, "").replaceAll("\\s{2}", " ");
                String[] s = string.split(" ");
                words += s.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    private static int getMarks(File f, int marks) {
        String string;
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(f))
        ) {
            while ((string = bufferedReader.readLine()) != null) {
                string = string.replaceAll(PATTERN, "1");
                String[] split = string.split(" ");
                for (String s : split) {
                    if (s.contains("1")) {
                        marks += 1;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return marks;
    }

    private static void printTextFile(int words, int marks, String textFile) {
        try (PrintWriter printWriter = new PrintWriter(textFile)
        ) {
            printWriter.println("words=" + words);
            printWriter.println("punctuation marks=" + marks);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
