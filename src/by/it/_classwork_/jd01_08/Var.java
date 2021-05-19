package by.it._classwork_.jd01_08;

abstract class Var implements Operation {

    public Var() {
        super();
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Operation %s + %s impossible\n", this, other);
        return null; //TODO generate exception
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation %s - %s impossible\n", this, other);
        return null; //TODO generate exception
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation %s * %s impossible\n", this, other);
        return null; //TODO generate exception
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation %s / %s impossible\n", this, other);
        return null; //TODO generate exception
    }

    @Override
    public String toString() {
        return "abstract Variable";
    }
}
