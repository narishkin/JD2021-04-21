package by.it.naryshkin.jd02_05.calc;

public class VarCreator {

    static Var get(String operand) throws CalcException {
        ResourceManager resourceManager = ResourceManager.INSTANCE;
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
            throw new CalcException(resourceManager.get(Messages.UNABLE_TO_PARSE) + operand);
        }
    }
}
