package by.it.stain.jd02_04;


abstract class Var implements Opration {


    public Var() {
        super();
    }

    @Override
    public Var add(Var other) throws CalcException {

        throw new CalcException("Operation add" + this + "+" + other + "impossible");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Operation sub" + this + "+" + other + "impossible");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Operation mul" + this + "+" + other + "impossible");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Operation div" + this + "+" + other + "impossible");
    }

    @Override
    public String toString() {

        return "Abstract Variable";
    }
}
