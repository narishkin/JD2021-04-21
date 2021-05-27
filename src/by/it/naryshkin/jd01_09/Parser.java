package by.it.naryshkin.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) {
        String[] operand = expression.split(Patterns.OPERATION);
        Var op1 = Var.createVar(operand[0]);
        Var op2 = Var.createVar(operand[1]);
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
