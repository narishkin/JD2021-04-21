package by.it.mogonov.jd02_04;


abstract class Var implements Operation {

    public Var() {super();}


    @Override
    public Var add(Var other)throws CalcException {
        throw new CalcException("Операция сложения " + this + "+" + other + " невозможна");

    }

    @Override
    public Var sub(Var other)throws CalcException {
        throw new CalcException("Операция вычитания " + this + "-" + other + " невозможна");

    }

    @Override
    public Var mul(Var other)throws CalcException {
        throw new CalcException("Операция умножения " + this + "*" + other + " невозможна");

    }

    @Override
    public Var div(Var other)throws CalcException {
        throw new CalcException("Операция деления " + this + "/" + other + " невозможна");

    }

}
