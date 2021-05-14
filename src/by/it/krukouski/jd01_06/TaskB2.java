package by.it.krukouski.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static final String WORD_PATTERN = "[а-яёА-ЯЁ:;,\\s-]+(\\.\\.\\.)?(\\.)";

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.TEXT);
        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Matcher matcher = pattern.matcher(text);
        int countSentence = 0;
        while (matcher.find()) {
            countSentence++;
        }
        System.out.println(countSentence);
        matcher.reset();
        String[] sentences = new String[countSentence];
        int i = 0;
        while (matcher.find()) {
            sentences[i] = matcher.group().replace("\n", " ").trim();
            i++;
        }
        for (int j = 0; j < sentences.length; j++) {
            for (int k = 0; k < sentences.length - 1; k++) {
                if (sentences[k].length() > sentences[k + 1].length()) {
                    String temp = sentences[k];
                    sentences[k] = sentences[k + 1];
                    sentences[k + 1] = temp;

                }

            }

        }

        for (String s : sentences) {
            System.out.printf("%s\n", s);
        }

    }
}


