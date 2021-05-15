package by.it.sapazhkou.jd01_06;

import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("\\\n");
        String[] arrayString = pattern.split(sb);
        int maxLengthString = 0;
        for (int i = 0; i < arrayString.length; i++) {
            if (maxLengthString < arrayString[i].length()) {
                maxLengthString = arrayString[i].length();
            }
        }
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i].length() < maxLengthString) {
                int lengthString = arrayString[i].length();
                int countInsertion = maxLengthString - lengthString;
                arrayString[i] = setInsertionToString(arrayString[i], countInsertion, maxLengthString);
            }
        }
        String text = "";
        for (int i = 0; i < arrayString.length; i++) {
            text = text.concat(arrayString[i]+"\n");
        }
        System.out.print(text);
    }

    private static String setInsertionToString(String str, int count, int maxString) {
        Pattern patternFofString = Pattern.compile("\\ ");
        String[] arrayWord = patternFofString.split(str);
        str = "";
        int loopMin = count / (arrayWord.length - 1);
        for (int i = 0; i < arrayWord.length-1; i++) {
 //           if (i < arrayWord.length - 1) {
                arrayWord[i] = arrayWord[i].concat(" ");
 //           }
            for (int j = 0; j < loopMin; j++) {
                arrayWord[i] = arrayWord[i].concat(" ");
            }
        }
        for (int i = 0; i < count - loopMin * (arrayWord.length - 1); i++) {
            arrayWord[i] = arrayWord[i].concat(" ");
        }
        for (int i = 0; i < arrayWord.length; i++) {
            str = str.concat(arrayWord[i]);
        }
        return str;
    }
}
