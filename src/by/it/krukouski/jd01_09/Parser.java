package by.it.krukouski.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    Var calc(String expression) {
        expression = expression.replace(" ", "");
        String[] parts = expression.split(Patterns.OPERATION, 2);
        if (parts.length == 1) {
            return VarCreator.createVar(parts[0]);
        }
        Var leftPart = VarCreator.createVar(parts[0]);
        Var rightPart = VarCreator.createVar(parts[1]);
        if (leftPart == null || rightPart == null) {
            System.out.println("Incorrect expression");
            return null;
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
