package by.it.nikitko.jd01_06;

import java.util.regex.Pattern;

public class TaskA1 {

    public static final String wordPattern = "[а-яёА-ЯЁ]{4,}";

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.TEXT);
        Pattern compile = Pattern.compile(wordPattern);

        System.out.println(text);


    }
}
