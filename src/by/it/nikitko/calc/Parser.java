package by.it.nikitko.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) throws CalcException {

        if (expression.equals("printvar")) {
            System.out.println(Var.getVars());
        }
        if (expression.equals("sortvar")) {
            System.out.println(Var.getVars().entrySet());
        }

        String[] parts = expression.split(Patterns.OPERATION, 2);

        if (parts.length == 1) {
            return Var.createVar(parts[0]);
        }
        Var right = Var.createVar(parts[1]);

        if (expression.contains("=")) {
            return Var.saveVar(parts[0], right);
        }
        Var left = Var.createVar(parts[0]);

        if (left == null || right == null) {
            throw new CalcException("Incorrect expression");
        }
        Pattern patternOperation = Pattern.compile(Patterns.OPERATION);
        Matcher matcherOperation = patternOperation.matcher(expression);
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
        throw new CalcException("Error");
    }
}
