package by.it.zhurauleu.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    private static final String SENTENCE_PATTERN = "[^.!?]+";
    private static final String NON_LETTER_PATTERN = "[^а-яА-ЯёЁ]+";
    private static String[] sentences = new String[0];

    public static void main(String[] args) {
        String textWithoutEllipsis = Poem.TEXT.replaceAll("\\.{3,}", "");
        StringBuilder text = new StringBuilder(textWithoutEllipsis);
        Pattern pattern = Pattern.compile(SENTENCE_PATTERN);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String sentence = matcher.group();
            sentence = replaceNonLetter(sentence);
            addSentenceToArray(sentence);
        }
        Arrays.sort(sentences, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }

    private static void addSentenceToArray(String sentence) {
        sentences = Arrays.copyOf(sentences, sentences.length + 1);
        sentences[sentences.length - 1] = sentence;
    }

    private static String replaceNonLetter(String sentence) {
        return sentence.replaceAll(NON_LETTER_PATTERN, " ").trim();
    }
}




