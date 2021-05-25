package by.it.stain.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {


    public static void main(String[] args) {
        step1();
        step2();

    }

    private static void step1() {
        String text = new String(Poem.TEXT);
        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher(Poem.TEXT);
        final  String [] SENTENCE = text.replace(". ", ".\n").replace("! ", "!\n").split("[\\.\\!]\n");
        int value = 0;



        for (int i = 0; i < SENTENCE.length; i++) {

            System.out.println(SENTENCE[i]+SENTENCE[i].length());
            if(SENTENCE[i].length()>value){
                value=SENTENCE[i].length();
            }
            System.out.println(SENTENCE[i].length());


        }
        for (int i = 0; i < SENTENCE.length; i++) {


        }


    }

    private static void step2() {
        Pattern pattern = Pattern.compile("(\\p{Punct}{1,})\\p{Blank}{0,}");
        Matcher matcher = pattern.matcher(Poem.TEXT);
        String text = matcher.replaceAll(" ");


       // System.out.println(text.trim());

    }
}
