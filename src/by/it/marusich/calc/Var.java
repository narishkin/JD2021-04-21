package by.it.marusich.calc;

abstract class Var implements Operation {

    public Var() {
        super();
    }

    @Override
    public Var add(Var other)  throws CalcException {
        String message = String.format("Operation %s + %s impossible\n", this, other);
        throw new CalcException(message);
    }

    @Override
    public Var sub(Var other)  throws CalcException {
        String message = String.format("Operation %s - %s impossible\n", this, other);
        throw new CalcException(message);
    }

    @Override
    public Var mul(Var other)  throws CalcException {
        String message = String.format("Operation %s * %s impossible\n", this, other);
        throw new CalcException(message);
    }

    @Override
    public Var div(Var other) throws CalcException {
        String message = String.format("Operation %s / %s impossible\n", this, other);
        throw new CalcException(message);
    }

    @Override
    public String toString() {
        return "abstract Variable";
    }
}
