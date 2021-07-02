package by.it.mogonov.calc;

import java.util.Scanner;

public class ConsoleRunner {

    static final String KEY_STOP_APP = "end";

    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        VarRepo.loadVars();

        Scanner input = new Scanner(System.in);
        for (; ; ) {
            String expression = input.nextLine();
            if (!expression.equals(KEY_STOP_APP)) {
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


