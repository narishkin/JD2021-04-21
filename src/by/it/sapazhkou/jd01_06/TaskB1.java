package by.it.sapazhkou.jd01_06;

import java.lang.String;

public class TaskB1 {

    public static void main(String[] args) {

        String vowelLetter = "аеёиоуыэяюАЕЁИОУЫЭЯЮ";
        String symbols = " ,.!:-\n";

        int startPosition = 0;
        int lastPosition = 0;
        String word = "";


        StringBuilder sb = new StringBuilder(Poem.text);
        for (int i = 0; i < sb.length(); i++) {
            for (int j = 0; j < symbols.length(); j++) {
                if (sb.charAt(i) == symbols.charAt(j)) {
                    lastPosition = i;
                    word = sb.substring(startPosition, lastPosition);
                    chekWord(word, vowelLetter);
//                    System.out.println(word);
                    startPosition = lastPosition + 1;
                    word = "";
                    break;
                }
            }
        }
    }

    static void chekWord(String word, String vowelLetter) {
        boolean firstConsonant = true;
        boolean lastVowel = false;
        if (word.equals("")){
            return;
        }
        for (int i = 0; i < vowelLetter.length(); i++) {
            if (word.charAt(0) == vowelLetter.charAt(i)) {
                firstConsonant = false;
                break;
            }
        }

        for (int i = 0; i < vowelLetter.length(); i++) {
            if (word.charAt(word.length() - 1) == vowelLetter.charAt(i)) {
                lastVowel = true;
                break;
            }
        }
        if (firstConsonant && lastVowel) {
            System.out.println(word);
        }

    }


}


