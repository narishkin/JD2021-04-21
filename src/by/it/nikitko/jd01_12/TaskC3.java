package by.it.nikitko.jd01_12;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {
    static final String REG_EXP_ROUND_BRACKET = "[\\(\\\\)]";
    static final String REG_EXP_SQUARE_BRACKET = "[\\[\\]]";
    static final String REG_EXP_CURLY_BRACKET = "[\\{\\\\}]";


    public static void main(String[] args) {

       // Scanner scanner = new Scanner(System.in);
      //  String inputString = scanner.nextLine();
         String inputString = "(a+b)*{e}}{-[45+a]()";
        System.out.println(roundBracketsProcessing(inputString) & squareBracketsProcessing(inputString) & curlyBracketsProcessing(inputString));

    }


    private static boolean roundBracketsProcessing(String inputString) {
        Deque<String> roundBrackets = new ArrayDeque<>();
        int counter = 0;
        Pattern pattern = Pattern.compile(REG_EXP_ROUND_BRACKET);
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find()) {
            String roundBracket = matcher.group();
            roundBrackets.add(roundBracket);
        }
        if (roundBrackets.getFirst().equals(")")) {
            return false;

        }
        while (!roundBrackets.isEmpty()) {
            String currentBracket = roundBrackets.pollFirst();
            //    System.out.println(currentBracket);
            if (currentBracket.equals("(")) {
                counter++;
            }
            if (currentBracket.equals(")")) {
                counter--;
            }
        }
        if (counter == 0) {
            return true;
        } else return false;
    }

    private static boolean squareBracketsProcessing(String inputString) {
        Deque<String> squareBrackets = new ArrayDeque<>();
        int counter = 0;
        Pattern pattern = Pattern.compile(REG_EXP_SQUARE_BRACKET);
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find()) {
            String squareBracket = matcher.group();
            squareBrackets.add(squareBracket);
        }
        if (squareBrackets.isEmpty()) {
            return true;
        }
        if (squareBrackets.getFirst().equals("]")) {
            return false;
        }
        while (!squareBrackets.isEmpty()) {
            String currentBracket = squareBrackets.pollFirst();
            //   System.out.println(currentBracket);
            if (currentBracket.equals("[")) {
                counter++;
            }
            if (currentBracket.equals("]")) {
                counter--;
            }
        }
        if (counter == 0) {
            return true;
        } else return false;
    }

    private static boolean curlyBracketsProcessing(String inputString) {
        Deque<String> roundBrackets = new ArrayDeque<>();
        int counter = 0;
        Pattern pattern = Pattern.compile(REG_EXP_CURLY_BRACKET);
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find()) {
            String roundBracket = matcher.group();
            roundBrackets.add(roundBracket);
        }
        if (roundBrackets.getFirst().equals("}")) {
            return false;

        }
        while (!roundBrackets.isEmpty()) {
            String currentBracket = roundBrackets.pollFirst();
            //   System.out.println(currentBracket);
            if (currentBracket.equals("{")) {
                counter++;
            }
            if (currentBracket.equals("}")) {
                counter--;
            }
        }
        if (counter == 0) {
            return true;
        } else return false;
    }
}
