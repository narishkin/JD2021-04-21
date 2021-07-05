package by.it.nikitko.calc;


abstract class Var implements Operation {


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
                throw new CalcException(ConsoleRunner.manager.get(Messages.INCORRECT_EXPRESSION));
            }
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(ConsoleRunner.manager.get(Messages.OPERATION_ADDITIONS)+" " + this + "+" + other +
                ConsoleRunner.manager.get(Messages.IS_IMPOSSIBLE));

    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(ConsoleRunner.manager.get(Messages.OPERATION_SUBTRACTION)+" " + this + "-" + other +
                ConsoleRunner.manager.get(Messages.IS_IMPOSSIBLE));

    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(ConsoleRunner.manager.get(Messages.OPERATION_MULTIPLICATION)+" " + this + "*" + other +
                ConsoleRunner.manager.get(Messages.IS_IMPOSSIBLE));

    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(ConsoleRunner.manager.get(Messages.OPERATION_DIVISION)+" " + this + "/" + other +
                ConsoleRunner.manager.get(Messages.IS_IMPOSSIBLE));

    }
}
