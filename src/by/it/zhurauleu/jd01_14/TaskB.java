package by.it.zhurauleu.jd01_14;

import java.io.*;
import java.nio.file.Path;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    static final String FILE_PATH = PathCreator.getFileName(TaskB.class, "Poem.txt");
    static final String WORD_PATTERN = "[а-яА-ЯёЁ]+";
    private static final String PUNCTUATION_PATTERN = "[-/?.!:,]+";
    public static final String TXT_FILE_NAME = "resultTaskB.txt";


    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String filePath = PathCreator.getFileName(TaskB.class, TXT_FILE_NAME);
        int wordsCount = countPatternMatches(FILE_PATH, WORD_PATTERN);
        int punctuationMarksCount = countPatternMatches(FILE_PATH, PUNCTUATION_PATTERN);
        System.out.printf("words=%d, ", wordsCount);
        System.out.printf("punctuation marks=%d ", punctuationMarksCount);
        PrintTxt(filePath, wordsCount, punctuationMarksCount);
    }

    private static void PrintTxt(String filePath, int wordsCount, int punctuationMarksCount) {
        try (
                PrintWriter printWriter = new PrintWriter(filePath)
        ) {
            printWriter.printf("words=%d, ", wordsCount);
            printWriter.printf("punctuation marks=%d ", punctuationMarksCount);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static int countPatternMatches(String filePath, String regEx) {
        int wordsCount = 0;
        String readLine;
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(filePath));
            while ((readLine = input.readLine()) != null) {
                Pattern pattern = Pattern.compile(regEx);
                Matcher matcher = pattern.matcher(readLine);
                while (matcher.find()) {
                    wordsCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return wordsCount;
    }
}
