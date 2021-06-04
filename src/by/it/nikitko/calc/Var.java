package by.it.nikitko.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();


    public static Map<String, Var> getVars() {
        return vars;
    }

    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    static Var createVar(String expression) {
        expression = expression.replaceAll("\\s+", "");

        if (expression.matches(Patterns.SCALAR))
            return new Scalar(expression);
        if (expression.matches(Patterns.VECTOR))
            return new Vector(expression);
        if (expression.matches(Patterns.MATRIX))
            return new Matrix(expression);
        if (vars.containsKey(expression))
            return vars.get(expression);
        System.out.println("Incorrect expression");
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Operation additions " + this + "+" + other + " is impossible");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Operation subtraction " + this + "-" + other + " is impossible");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Operation multiplication " + this + "*" + other + " is impossible");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Division operation " + this + "/" + other + " is impossible");
        return null;
    }
}
