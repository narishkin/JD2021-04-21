package by.it._classwork_.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    static final String KEY_STOP_APP = "end";

    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner input = new Scanner(System.in);
        for (; ; ) {
            //2+2
            String expression = input.nextLine();
            if (!expression.equals(KEY_STOP_APP)) {
                Var var = parser.evaluate(expression);
                printer.print(var);
            } else {
                break;
            }
        }
    }
}
