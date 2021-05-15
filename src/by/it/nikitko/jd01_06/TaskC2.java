package by.it.nikitko.jd01_06;

import by.it.nikitko.jd01_05.Helper;

public class TaskC2 {



    public static void main(String[] args) {

        String slowString =slow(Poem.TEXT);


    }

    public static String slow (String text) {
        String[] words = text.split("[^а-яёА-ЯЁ]+");
       // System.out.println(words.length);
        String string =("");
        for (int i = 0; i < 100000; i++) {
            String addedString = words[Helper.getRandomNumber(0, words.length-1)];
            string = string.concat(addedString).concat(" ");
        }

        System.out.println(string);


        return text;
    }
}
