package by.it.naryshkin.jd02_04.calcbracket;

public class VarCreator {

    static Var get(String operand) throws CalcException {
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
            return VarRepo.vars.get(operand);
        } else {
            throw new CalcException("Unable to parse expression " + operand);
        }
    }
}
