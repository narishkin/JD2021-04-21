package by.it.naryshkin.jd02_05.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    ResourceManager resourceManager = ResourceManager.INSTANCE;
    Printer printer = new Printer();
    private static final Map<String, Integer> PRIORITY = Map.of("=", 0, "+", 1, "-", 1, "*", 2, "/", 2);
    Var calc(String expression) throws CalcException {
        if (expression.equals("printvar")) {
            printer.printMap(VarRepo.getVar());
            return null;
        }
        if (expression.equals("sortvar")) {
            printer.sortedPrintMap(VarRepo.getVar());
            return null;
        }
        if (expression.contains("(")) {
            int posPointer = 0;
            int posOpenBracket = 0;
            int posCloseBracket = 0;
            while (posPointer < expression.length()) {
                if (expression.charAt(posPointer) == '(') {
                    posOpenBracket = posPointer;
                }
                if (expression.charAt(posPointer) == ')') {
                    posCloseBracket = posPointer;
                    break;
                }
                posPointer++;
            }
            StringBuilder inBrackets = new StringBuilder();
            if (posCloseBracket<=posOpenBracket){
                throw new CalcException(resourceManager.get(Messages.INCORRECT_EXPRESSION));
            }
            for (int i = posOpenBracket + 1; i < posCloseBracket; i++) {
                inBrackets.append(expression.charAt(i));
            }
            StringBuilder expressionSimplified = new StringBuilder(expression);
            expressionSimplified.delete(posOpenBracket, posCloseBracket + 1);
            return calc(expressionSimplified.insert(posOpenBracket, calc(inBrackets.toString())).toString());
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
            String operationType = operation.remove(index);
            String left = operand.remove(index);
            String right = operand.remove(index);
            String result = calcOneOperation(left, operationType, right).toString();
            operand.add(index, result);
        }
        return VarCreator.get(operand.get(0));
    }


    private Var calcOneOperation(String left, String operationType, String right) throws CalcException {
        Var op2 = VarCreator.get(right);
        if (operationType.equals("=")) {
            VarRepo.setVar(left, op2);
            return op2;
        }
        Var op1 = VarCreator.get(left);
        if (op1 == null || op2 == null) {
            throw new CalcException(resourceManager.get(Messages.INCORRECT_EXPRESSION));
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
        throw new CalcException(resourceManager.get(Messages.INCORRECT_EXPRESSION));
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
