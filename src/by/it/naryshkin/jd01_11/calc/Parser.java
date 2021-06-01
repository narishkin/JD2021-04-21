package by.it.naryshkin.jd01_11.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Printer printer = new Printer();

    Var calc(String expression) {
        if (expression.equals("printvar")) {
            printer.printMap(Var.getVar());
            return null;
        }
        if (expression.equals("sortvar")) {
            printer.sortedPrintMap(Var.getVar());
            return null;
        }
        String[] operand = expression.split(Patterns.OPERATION, 2);
        Var op1 = Var.createVar(operand[0]);
        Var op2 = Var.createVar(operand[1]);
//        System.out.println(operand[0] + " " + operand[1]);
        if (expression.contains("=")) {
            return Var.setVar(operand[0], op2);
        }

        if (op1 == null || op2 == null) {
            return null;
        }
        Pattern p1 = Pattern.compile(Patterns.OPERATION);
        Matcher m1 = p1.matcher(expression);
        if (m1.find()) {
            String operationType = m1.group();
            switch (operationType) {
                case "+":
                    return op1.add(op2);
                case "-":
                    return op1.sub(op2);
                case "*":
                    return op1.mul(op2);
                case "/":
                    return op1.div(op2);
            }
        }
        return null;
    }
}
