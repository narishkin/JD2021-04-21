package by.it.naryshkin.jd02_04.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Printer printer = new Printer();
    private static final Map<String, Integer> PRIORITY = Map.of("=", 0, "+", 1, "-", 1, "*", 2, "/", 2);

    Var calc(String expression) throws CalcException {
        if (expression.equals("printvar")) {
            printer.printMap(Var.getVar());
            return null;
        }
        if (expression.equals("sortvar")) {
            printer.sortedPrintMap(Var.getVar());
            return null;
        }

        List<String> operand = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operation = new ArrayList<>();
        Pattern p1 = Pattern.compile(Patterns.OPERATION);
        Matcher m1 = p1.matcher(expression);
        while (m1.find()) {
            operation.add(m1.group());
        }
        while (operation.size() > 0) {
            int index = getIndexOperation(operation);
            String operationType = operation.remove(index);//A=2+-4*-2/8
            String left = operand.remove(index);
            String right = operand.remove(index);
            String result = calcOneOperation(left, operationType, right).toString();
            operand.add(index,result);
        }
        return VarCreator.get(operand.get(0));
    }

    private Var calcOneOperation(String leftOperandString, String operationType, String rightOperandString) throws CalcException {
        Var op2 = VarCreator.get(rightOperandString);
        if (operationType.equals("=")) {
            Var.setVar(leftOperandString, op2);
            return op2;
        }
        Var op1 = VarCreator.get(leftOperandString);
        if (op1 == null || op2 == null) {
            throw new CalcException("Incorrect expression");
        }
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
        throw new CalcException("Incorrect expression");
    }

    private int getIndexOperation(List<String> operation) {
        int index = -1;
        int prior = -1;
        for (int i = 0; i < operation.size(); i++) {
            String op = operation.get(i);
            if (PRIORITY.get(op) > prior) {
                prior = PRIORITY.get(op);
                index = i;
            }
        }
        return index;
    }
}
