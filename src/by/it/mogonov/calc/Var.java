package by.it.mogonov.calc;


import static by.it.mogonov.calc.Patterns.SCALAR;

abstract class Var implements Operation {

    static Object createVAR(String operand)throws CalcException{
        operand=operand.trim().replace("\\s+","");
        if(operand.matches(SCALAR))
            return new Scalar(operand);
        if(operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if(operand.matches(Patterns.MATRIX))
            return new Scalar(operand);
       throw  new CalcException("Невозможно создать "+operand);
    }
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
