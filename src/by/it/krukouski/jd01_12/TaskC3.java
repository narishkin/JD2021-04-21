package by.it.krukouski.jd01_12;

import java.util.Scanner;
import java.util.Stack;

public class TaskC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        System.out.println(characterArrangement(string));


    }

    private static boolean characterArrangement(String string) {
        Stack<Character> stack = new Stack<>();
        char[] charsArray = string.toCharArray();
        for (char ch : charsArray) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            }
            if (!stack.isEmpty()) {
                if (ch == '}' && stack.peek() == '{' ||
                        ch == ']' && stack.peek() == '[' ||
                        ch == ')' && stack.peek() == '(') {
                    stack.pop();
                }
            } else return false;
        }
        return stack.isEmpty();
    }
}
