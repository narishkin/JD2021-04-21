package by.it.nakov.jd02_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("DublicateCode")
public class Parser {

    private static final Map<String, Integer> PRIORITY = Map.of("=", 0, "+", 1, "-", 1, "*", 2, "/", 2);

    Var evaluate(String expression) throws CalcException {
        expression = expression.replace(" ", "");
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        } while (operations.size() > 0) {
            int index = getIndexOperation(operations);
            String operation = operations.remove(index);
            String one = operands.remove(index);
            String two = operands.remove(index);
            String result = calcOneOperation(one, operation, two).toString();
            operands.add(index, result);
        }
        return VarCreator.get(operands.get(0));
    }

    private Var calcOneOperation(String oneString, String operation, String twoString) throws CalcException {
        Var two = VarCreator.get(twoString);
        if (operation.equals("=")) {
            VarRepo.save(twoString, two);
            return two;
        }
        Var one = VarCreator.get(oneString);
        if (one == null || two == null) {
            throw new CalcException("Incorrect expression");
        }
        switch (operation) {
            case "+":
                return one.add(two);
            case "-":
                return one.sub(two);
            case "/":
                return one.div(two);
            case "*":
                return one.mul(two);
        }
        throw new CalcException("Incorrect expression");

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
}
