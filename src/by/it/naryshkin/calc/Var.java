package by.it.naryshkin.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
    private static Map<String, Var> vars = new HashMap<>();

    static Var setVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    public static Map<String, Var> getVar() {
        return vars;
    }


    static Var createVar(String operand) throws CalcException{
        operand = operand.trim();
        operand = operand.replaceAll("\\s+", "");
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        } else
        if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        } else
        if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand);
        } else
        if (operand.matches(Patterns.VARNAME)) {
            return vars.get(operand);
        } else {
            throw new CalcException("Unable to parse expression " + operand);
        }
    }

    @Override
    public Var add(Var other) throws CalcException{
        throw new CalcException("Операция сложения " + this + "+" + other + " невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException("Операция вычитания " + this + "-" + other + " невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException("Операция умножения " + this + "*" + other + " невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException("Операция деления " + this + "/" + other + " невозможна");
    }
}
