package by.it.marusich.jd01_09;


import java.util.Scanner;

public class ConsoleRunner {
    static final String KEY_WORD = "end";

    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String expression = scanner.nextLine();
            if (!expression.equals(KEY_WORD)) {
                Var var = parser.calc(expression);
                printer.print(var);
            } else {
                break;
            }
        }
    }
}
