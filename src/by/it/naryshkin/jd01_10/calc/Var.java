package by.it.naryshkin.jd01_10.calc;

abstract class Var implements Operation {

    static Var createVar(String operand) {
        operand = operand.trim();
        operand = operand.replaceAll("\\s+", "");
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        }
        if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        }
        if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand);
        }
        return null;
    }




    @Override
    public Var add(Scalar other) {
        System.out.println("Операция сложения скаляр" + this + "+" + other + " невозможна");
        return null;
    }

    @Override
    public Var add(Vector other) {
        return null;
    }

    @Override
    public Var add(Matrix other) {
        return null;
    }




    @Override
    public Var sub(Scalar other) {
        return null;
    }

    @Override
    public Var sub(Vector other) {
        return null;
    }

    @Override
    public Var sub(Matrix other) {
        return null;
    }





    @Override
    public Var mul(Scalar other) {
        return null;
    }

    @Override
    public Var mul(Vector other) {
        return null;
    }

    @Override
    public Var mul(Matrix other) {
        return null;
    }





    @Override
    public Var div(Scalar other) {
        return null;
    }

    @Override
    public Var div(Vector other) {
        return null;
    }

    @Override
    public Var div(Matrix other) {
        System.out.println("Impossible division");
        return null;
    }



//    @Override
//    public Var add(Vector other) {
//        return null;
//    }
//
//    @Override
//    public Var add(Matrix other) {
//        return null;
//    }
//    @Override
//    public Var add(Var other) {
//        System.out.println("Операция сложения " + this + "+" + other + " невозможна");
//        return null;
//    }
//    @Override
//    public Var sub(Var other) {
//        System.out.println("Операция вычитания " + this + "-" + other + " невозможна");
//        return null;
//    }
//
//    @Override
//    public Var mul(Var other) {
//        System.out.println("Операция умножения " + this + "*" + other + " невозможна");
//        return null;
//    }
//
//    @Override
//    public Var div(Var other) {
//        System.out.println("Операция деления " + this + "/" + other + " невозможна");
//        return null;
//    }
}
