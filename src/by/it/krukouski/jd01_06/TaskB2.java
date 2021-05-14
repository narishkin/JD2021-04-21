package by.it.krukouski.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static final String WORD_PATTERN = "[а-яёА-ЯЁ:;,\\s-]+(\\.)";
    public static String[] sentences = new String[0];

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.TEXT);
        Pattern p = Pattern.compile("\\s");
        Matcher m = p.matcher(text);
        Pattern p1 = Pattern.compile(WORD_PATTERN);
        Matcher m1 = p1.matcher(text);
        while (m.find()) {
            String e = m.replaceAll(" ");
            text.replace(0, text.length() - 1, e);
        }
        //System.out.println(text);
        while (m1.find()) {
            String e = m1.group();
            e = e.trim();
            System.out.println(Arrays.toString(stringArray(e)));


        }



    }

    private static CharSequence[] stringArray(String e) {
        String[] array = new String[1];
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            array[i]=e;
            length = array[i].charAt(e.length()-1)-array[i].charAt(0);
            System.out.println(length);

        }

        return array;
    }


}


