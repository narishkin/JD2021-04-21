package by.it.marusich.jd01_09;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public by.it.marusich.jd01_09.Var calc(String expression) {
        expression = expression.replace(" ", "");
        String[] parts = expression.split(by.it.marusich.jd01_09.Patterns.OPERATION, 2);
        if (parts.length == 1) {
            return (Var) VarCreator.getVar(parts[0]);
        }
        by.it.marusich.jd01_09.Var leftPart = (Var) VarCreator.getVar(parts[0]);
        Var rightPart = (Var) VarCreator.getVar(parts[1]);
        if (leftPart == null || rightPart == null) {
            System.out.println("incorrect expression");
            return null;
        }
        Pattern operationPattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcherOperation = operationPattern.matcher(expression);
        if (matcherOperation.find()) {
            String operation = matcherOperation.group();
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
        return null;
    }
}


