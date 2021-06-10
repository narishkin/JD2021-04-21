package by.it.krukouski.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    Var calc(String expression) throws CalcException {
        expression = expression.replace(" ", "");
        String[] parts = expression.split(Patterns.OPERATION, 2);
        if (parts.length == 1) {
            return VarCreator.createVar(parts[0]);
        }
        Var rightPart = VarCreator.createVar(parts[1]);
        if (expression.contains("=")) {
            String name = parts[0];
            VarRepo.save(name, rightPart);
            return rightPart;
        }
        Var leftPart = VarCreator.createVar(parts[0]);
        if (leftPart == null || rightPart == null) {
            throw new CalcException("Incorrect expression");
        }
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcher.find()) {
            String operation = matcher.group();
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
        }
        System.out.println("Amazingly");
        return null;
    }
}
