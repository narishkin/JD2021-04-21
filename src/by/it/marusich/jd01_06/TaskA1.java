package by.it.marusich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[]args){
       String text = Poem.text;

    StringBuilder sb = new StringBuilder(by.it.marusich.jd01_06.Poem.text);
    Pattern p1 = Pattern.compile("[а-яА-ЯёЁ]{4,}");
    Matcher m1 = p1.matcher(by.it.marusich.jd01_06.Poem.text);
        while (m1.find()) {
        int start = m1.start();
        sb.setCharAt(start + 3, '#');
        if (m1.group().length() >= 7) {
            sb.setCharAt(start + 6, '#');
        }
    }
        System.out.println(sb.toString());

}
}


