package by.it.naryshkin.jd01_10.calc;

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
                case "+": {
                    if (op2 instanceof Scalar)
                        return op1.add((Scalar) op2);
                    if (op2 instanceof Vector)
                        return op1.add((Vector) op2);
                    if (op2 instanceof Matrix)
                        return op1.add((Matrix) op2);
                }

                case "-": {
                    if (op2 instanceof Scalar)
                        return op1.sub((Scalar) op2);
                    if (op2 instanceof Vector)
                        return op1.sub((Vector) op2);
                    if (op2 instanceof Matrix)
                        return op1.sub((Matrix) op2);

                }
                case "*": {
                    if (op2 instanceof Scalar)
                        return op1.mul((Scalar) op2);
                    if (op2 instanceof Vector)
                        return op1.mul((Vector) op2);
                    if (op2 instanceof Matrix)
                        return op1.mul((Matrix) op2);
                }
                case "/": {
                    if (op2 instanceof Scalar)
                        return op1.div((Scalar) op2);
                    if (op2 instanceof Vector)
                        return op1.div((Vector) op2);
                    if (op2 instanceof Matrix)
                        return op1.div((Matrix) op2);
                }
            }
        }
        return null;
    }
}
