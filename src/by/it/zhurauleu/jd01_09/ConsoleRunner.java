package by.it.zhurauleu.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    static final String KEY_STOP_APP = "end";

    public static void main(String[] args) {
        Parser parser = new Parser();
        Printer printer = new Printer();
        Scanner input = new Scanner(System.in);
        for (; ; ) {
            String expression = input.nextLine();
            if (!expression.equals(KEY_STOP_APP)) {
                Var result = parser.calc(expression);
                printer.print(result);
            } else break;
        }
    }
}
