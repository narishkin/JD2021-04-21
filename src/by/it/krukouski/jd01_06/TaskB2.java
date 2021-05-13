package by.it.krukouski.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static final String WORD_PATTERN = "[а-яёА-ЯЁ:;,\\s-]+(\\.!)";


    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.TEXT);
        Pattern p = Pattern.compile("\n");
        Matcher m = p.matcher(text);
        while (m.find()){
            String e = m.replaceAll(" ");
            System.out.println(e);

        }
        //Pattern pattern = Pattern.compile(WORD_PATTERN);
      //Matcher matcher = pattern.matcher(text);
        //System.out.println(text);


    }
}
