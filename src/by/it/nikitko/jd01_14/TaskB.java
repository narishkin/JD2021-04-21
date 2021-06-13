package by.it.nikitko.jd01_14;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static final String TXT_NAME = "Poem.txt";
    private static final String TXT_RESULT = "resultTaskB.txt";
    public static final String WORD_PATTERN = "[а-яёА-ЯЁ]+";
    public static final String PUNCT_MARKS_PATTERN = "[.,!:-]+";


    public static void main(String[] args) throws IOException {

        print(countWords(),countPunctMarks());

    }

    private static int countWords() {
        List<String> words = new ArrayList<>();
        Pattern patternWord = Pattern.compile(WORD_PATTERN);
        Matcher matcherWord = patternWord.matcher(readTxtFile());
        while (matcherWord.find()) {
            String word = matcherWord.group();
            words.add(word);
        }
        return words.size();
    }

    private static int countPunctMarks() {
        List<String> punctMarks = new ArrayList<>();
        Pattern patternPunctMarks = Pattern.compile(PUNCT_MARKS_PATTERN);
        Matcher matcherPunctMarks = patternPunctMarks.matcher(readTxtFile());
        while (matcherPunctMarks.find()) {
            String punctMark = matcherPunctMarks.group();
            punctMarks.add(punctMark);
        }
        return punctMarks.size();
    }

    private static StringBuilder readTxtFile() {

        StringBuilder poem = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PathCreator.getPath(TaskB.class) + TXT_NAME))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                poem.append(line).append(" ");
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return poem;
    }

    public static void print(int countWords, int countPunctMarks) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(PathCreator.getPath(TaskA.class) + TXT_RESULT))) {
            System.out.printf("words=%d, punctuation marks=%d", countWords, countPunctMarks);
            printWriter.printf("words=%d, punctuation marks=%d", countWords, countPunctMarks);
        }
    }

}
