package by.it.krukouski.jd02_05.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final Map<String, Integer> PRIORITY = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    Var calc(String expression) throws CalcException {
        StringBuilder stringBrackets = new StringBuilder(expression);
        Matcher matcherBrackets;
        while ((matcherBrackets = Pattern
                .compile(Patterns.BRACKETS)
                .matcher(stringBrackets))
                .find()) {
            int startIndex = matcherBrackets.start();
            int endIndex = matcherBrackets.end();
            Var resultString = calc(stringBrackets.substring(startIndex + 1, endIndex - 1));
            stringBrackets.replace(startIndex, endIndex, resultString.toString());
        }

        String finalExpression = stringBrackets.toString().replace(" ", "");
        List<String> operands = new ArrayList<>(Arrays.asList(finalExpression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        Matcher matcher = Pattern
                .compile(Patterns.OPERATION)
                .matcher(finalExpression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        while (operations.size() > 0) {
            int index = getIndexOperation(operations);
            String operation = operations.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            String result = calcOperation(operation, left, right).toString();
            operands.add(index, result);
        }

        return VarCreator.createVar(operands.get(0).replace(" ", ""));
    }

    private int getIndexOperation(List<String> operations) {
        int index = -1;
        int priority = -1;
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            if (PRIORITY.get(operation) > priority) {
                priority = PRIORITY.get(operation);
                index = i;
            }
        }
        return index;
    }

    private Var calcOperation(String operation, String leftString, String rightString) throws CalcException {

        Var rightPart = VarCreator.createVar(rightString);
        if (operation.equals("=")) {
            VarRepo.save(leftString, rightPart);
            return rightPart;
        }

        Var leftPart = VarCreator.createVar(leftString);
        if (leftPart == null || rightPart == null) {
            throw new CalcException(ResMan.INSTANCE.get(Errors.incorrectExpression));
        }
        switch (operation) {
            case "+":
                return leftPart.add(rightPart);
            case "-":
                return leftPart.sub(rightPart);
            case "*":
                return leftPart.mul(rightPart);
            case "/":
                return leftPart.div(rightPart);
        }
        throw new CalcException(ResMan.INSTANCE.get(Errors.incorrectExpression));
    }
}
