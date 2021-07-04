package by.it.krukouski.jd02_05.calc;

abstract class Var implements Operation {
    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(ResMan.INSTANCE.get(Errors.operationImpossible));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(ResMan.INSTANCE.get(Errors.operationImpossible));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(ResMan.INSTANCE.get(Errors.operationImpossible));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(ResMan.INSTANCE.get(Errors.operationImpossible));
    }

    public String toString() {
        return ResMan.INSTANCE.get(Errors.abstractVariable);
    }
}
