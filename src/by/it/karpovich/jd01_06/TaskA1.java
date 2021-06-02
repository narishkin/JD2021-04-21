package by.it.karpovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {

    public static final String PATTERN = "[а-яёА-ЯЁ]{4,}";
    public static final char ONPLACE_CHAR = '#';

    public static void main(String[] args){
        StringBuilder text = new StringBuilder(Poem.text);

        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int position = matcher.start();
            text.setCharAt(position + 3, ONPLACE_CHAR);
            int wordLenght = matcher.end() - matcher.start();
            if (wordLenght >= 7) {
                text.setCharAt(position + 6, ONPLACE_CHAR);
            }
        }
        System.out.println(text);
    }
    }

