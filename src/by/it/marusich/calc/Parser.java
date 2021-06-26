package by.it.marusich.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    Var evaluate(String expression) throws CalcException {
        expression = expression.replace(" ", "");
        String[] parts = expression.split(Patterns.OPERATION, 2);
        if (parts.length == 1) {
            return VarCreator.get(parts[0]);
        }
        Var right = VarCreator.get(parts[1]);
        if (expression.contains("=")) {
            String name = parts[0];
            VarRepo.save(name, right);
            return right;
        }

        Var left = VarCreator.get(parts[0]);
        if (left == null || right == null) {
            System.out.println("Incorrect expression");
            return null;
        }
        Matcher matcherOperation = Pattern
                .compile(Patterns.OPERATION)
                .matcher(expression);
        if (matcherOperation.find()) {
            String operation = matcherOperation.group();
            switch (operation) {
                case "+":
                    return left.add(right);
                case "-":
                    return left.sub(right);
                case "*":
                    return left.mul(right);
                case "/":
                    return left.div(right);
            }
        }
        System.out.println("Something stupid");
        return null; //stub
    }

}
