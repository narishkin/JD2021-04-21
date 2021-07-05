package by.it.stain.jd02_04;

import java.util.Scanner;

public class ConsoleRunner {

    static final String STOP = "end";

    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        VarRepo.loadVars();
        Scanner scanner = new Scanner(System.in);

        for (; ; ) {
            String expression = scanner.nextLine();
            if (!expression.equals(STOP)) {
                try {
                    Var var = parser.evaluate(expression);
                    printer.print(var);
                } catch (CalcException e) {
                    printer.print(e);
                }
            } else {
                VarRepo.saveVars();
                break;
            }
        }


    }
}
