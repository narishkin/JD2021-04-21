package by.it.naryshkin.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static final String vowel = "аеёиоуыэюяАЕЁИОУЫЭЮЯ";
    private  static final Pattern p1 = Pattern.compile("[а-яА-ЯЁё]+");
    public static void main(String[] args) {


        Matcher m1 = p1.matcher(Poem.text);
        while (m1.find()){
            if (checkWord(m1.group())){
                System.out.println(m1.group());

            }
        }
    }
    private static boolean checkWord(String word){
        boolean firstLetter = vowel.indexOf(word.charAt(0)) < 0;
        boolean lastLetter = vowel.indexOf(word.charAt(word.length()-1))>=0;
        return firstLetter && lastLetter;



    }

}
