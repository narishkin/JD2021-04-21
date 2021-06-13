package by.it.nikitko.jd01_12;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {
    static final String REG_EXP_BRACKETS = "[(){}\\[\\]]";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        System.out.println(bracketsProcessing(inputString));
    }

    private static boolean bracketsProcessing(String inputString) {
        Deque<String> brackets = new ArrayDeque<>();
        Pattern patternBrackets = Pattern.compile(REG_EXP_BRACKETS);
        Matcher matcher = patternBrackets.matcher(inputString);
        while (matcher.find()) {
            String currentBracket = matcher.group();
            if (currentBracket.equals("(") || currentBracket.equals("{") || currentBracket.equals("["))
                brackets.add(currentBracket);

            if (currentBracket.equals(")") || currentBracket.equals("}") || currentBracket.equals("]")) {
                if (brackets.isEmpty()) {
                    return false;
                }
                switch (brackets.pollLast()) {
                    case ("("):
                        if (!currentBracket.equals(")")) {
                            return false;
                        }
                        break;
                    case ("{"):
                        if (!currentBracket.equals("}")) {
                            return false;
                        }
                        break;
                    case ("["):
                        if (!currentBracket.equals("]")) {
                            return false;
                        }
                        break;
                }
            }
        }
        return brackets.isEmpty();
    }

}
