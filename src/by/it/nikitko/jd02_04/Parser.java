package by.it.nikitko.jd02_04;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {


    private static final Map<String, Integer> PRIORITY = Map.of(
            "=", 0,
            "+", 1, "-", 1,
            "*", 2, "/", 2
    );

    Var calc(String expression) throws CalcException {
        if (expression.equals("printvar")) {
            System.out.println(VarRepo.getVars());
        }
        if (expression.equals("sortvar")) {
            System.out.println(VarRepo.getVars().entrySet());
        }
        expression = scopesFinder(expression);

        List<String> operands = new ArrayList<>(
                Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        Matcher matcher = Pattern
                .compile(Patterns.OPERATION)
                .matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }

        while (operations.size() > 0) {
            int index = getIndexOperation(operations);
            String operation = operations.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            String result = calcOneOperation(left, operation, right).toString();
            operands.add(index, result);
        }
        return Var.createVar(operands.get(0));

    }

    private int getIndexOperation(List<String> operations) {
        int index = -1;
        int pr = -1;
        for (int i = 0; i < operations.size(); i++) {
            String op = operations.get(i);
            if (PRIORITY.get(op) > pr) {
                pr = PRIORITY.get(op);
                index = i;
            }
        }
        return index;
    }

    private Object calcOneOperation(String leftString, String operationString, String rightString) throws CalcException {

        Var right = Var.createVar(rightString);
        if (operationString.equals("=")) {
            VarRepo.save(leftString, right);
            return right;
        }
        Var left = Var.createVar(leftString);
        if (left == null || right == null) {
            throw new CalcException("Incorrect expression");
        }
        switch (operationString) {
            case "+":
                return left.add(right);
            case "-":
                return left.sub(right);
            case "*":
                return left.mul(right);
            case "/":
                return left.div(right);
        }
        throw new CalcException("Error");
    }

    public String scopesFinder(String expression) throws CalcException {

        ArrayDeque<Character> expressionCharDeque = new ArrayDeque<>();
        ArrayDeque<Character> leftPartExpression = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();

        char[] charArray = expression.toCharArray();
        for (char c : charArray) {
            expressionCharDeque.add(c);
        }

        while (expressionCharDeque.contains(')')) {
            StringBuilder currScopeSB = new StringBuilder();
            char currChar = expressionCharDeque.pollFirst();
            leftPartExpression.add(currChar);
            if (currChar == ')') {
                while (currChar != '(' & !leftPartExpression.isEmpty()) {
                    currChar = leftPartExpression.pollLast();
                    currScopeSB.append(currChar);
                }
                String currScopeString = currScopeSB.reverse().toString().replaceAll("[\\(\\)]", "");
               // System.out.println(currScopeString);
                char[] currentScopeResult = calc(currScopeString).toString().toCharArray();
                for (int i = currentScopeResult.length - 1; i >= 0; i--) {
                    expressionCharDeque.addFirst(currentScopeResult[i]);
                }
                while (!leftPartExpression.isEmpty()) {
                    expressionCharDeque.addFirst(leftPartExpression.pollLast());
                }
              //  System.out.println(expressionCharDeque);
            }
        }
        for (Character character : expressionCharDeque) {
            result.append(character);
        }
       return result.toString();
      //  System.out.println(calc(result.toString()));
    }
}
