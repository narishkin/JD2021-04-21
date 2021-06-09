package by.it.naryshkin.jd01_12;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String reg = "({9+9])";
        String s = sc.next();
        System.out.println(isCorrectBrackets(s));
    }

    static boolean isCorrectBrackets(String expression) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = expression.toCharArray();
        System.out.println(charArray);
        for (char symbol : charArray) {
            if (symbol == '(' || symbol == '[' || symbol == '{') {
                stack.push(symbol);
            }
            if (!stack.isEmpty()) {
                if (symbol == ')' && stack.peek() == '(' ||
                        symbol == ']' && stack.peek() == '[' ||
                        symbol == '}' && stack.peek() == '{') {
                    stack.pop();
                }
            } else return false;
        }
        return (stack.isEmpty());
    }
}
