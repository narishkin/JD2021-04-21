package by.it.naryshkin.jd02_06.calc;

abstract class Var implements Operation {
ResourceManager resourceManager = ResourceManager.INSTANCE;

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(resourceManager.get(Messages.ADDITIONAL_OPERATION) + this + "+" + other + resourceManager.get(Messages.IMPOSSIBLE));

    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(resourceManager.get(Messages.SUBTRACTION_OPERATION) + this + "-" + other + resourceManager.get(Messages.IMPOSSIBLE));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(resourceManager.get(Messages.MULTIPLICATION_OPERATION) + this + "*" + other + resourceManager.get(Messages.IMPOSSIBLE));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(resourceManager.get(Messages.DIVISION_OPERATION) + this + "/" + other + resourceManager.get(Messages.IMPOSSIBLE));
    }
}
