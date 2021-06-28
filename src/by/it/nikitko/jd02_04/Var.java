package by.it.nikitko.jd02_04;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

   /* public static Map<String, Var> getVars() {
        return vars;
    }

    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }*/

    static Var createVar(String expression) throws CalcException {
        expression = expression.replaceAll("\\s+", "");



        if (expression.matches(Patterns.SCALAR))
            return new Scalar(expression);
        if (expression.matches(Patterns.VECTOR))
            return new Vector(expression);
        if (expression.matches(Patterns.MATRIX)) {
            return new Matrix(expression);
        } else {
            if (VarRepo.contain(expression)) {
                return VarRepo.load(expression);
            } else {
                throw new CalcException("Incorrect expression1");
            }
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Operation additions " + this + "+" + other + " is impossible");

    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Operation subtraction " + this + "-" + other + " is impossible");

    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Operation multiplication " + this + "*" + other + " is impossible");

    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Division operation " + this + "/" + other + " is impossible");

    }
}
