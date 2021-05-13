package by.it.nikitko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    public static final String WORD_PATTERN = "[\\.][^\\...]";
    String [] ArrayOfSentence;


    public static void main(String[] args) {
        int sentenceCount =0;

        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Matcher matcher = pattern.matcher(Poem.TEXT);
        while (matcher.find()) {
            sentenceCount++;


         //   String word = matcher.group();
         //   StringBuilder predl = new StringBuilder();
          //  predl.append(word);
            }
        System.out.println(sentenceCount);
        }
    }

















