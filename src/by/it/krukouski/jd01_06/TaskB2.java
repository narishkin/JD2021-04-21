package by.it.krukouski.jd01_06;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static final String WITHOUT = "\\s?[-,:]{1}\\s{1}";
    public static final String SENTENCES_PATTERN = "[^.!?]+";
    public static String[] sentences = new String[0];


    public static void main(String[] args) {
        String textWithoutSymbols = Poem.TEXT.replaceAll(WITHOUT, " ");
        String newText = textWithoutSymbols.replaceAll("\\.{3}", "");
        StringBuilder text = new StringBuilder(newText);
        Pattern pattern = Pattern.compile(SENTENCES_PATTERN);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String sentence = matcher.group().replace("\n", " ");
            sentence = sentence.trim();
            sentenceToArray(sentence);
        }
        for (int i = 0; i < sentences.length; i++) {
            for (int j = 0; j < sentences.length - i - 1; j++) {
                String long1 = sentences[j];
                String long2 = sentences[j + 1];
                if (long1.length() > long2.length()) {
                    String temp = sentences[j];
                    sentences[j] = sentences[j + 1];
                    sentences[j + 1] = temp;
                }

            }

        }

        for (String sentence : sentences) {
            System.out.printf("%s\n", sentence);

        }

    }

    private static void sentenceToArray(String sentence) {
        sentences = Arrays.copyOf(sentences, sentences.length + 1);
        sentences[sentences.length - 1] = sentence;
    }
}
