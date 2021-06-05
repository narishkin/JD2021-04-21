package by.it.naryshkin.jd01_10.calc;

class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    @Override
    public Var add(Scalar other) {
        double sum = this.value + other.value;
        System.out.println("jyj");
        return new Scalar(sum);
    }

    @Override
    public Var sub(Scalar other) {
        double sub = this.value - other.value;
        return new Scalar(sub);
    }


    @Override
    public Var mul(Scalar other) {
        double mul = this.value * other.value;
        return new Scalar(mul);
    }

    @Override
    public Var div(Scalar other) {
        double div = this.value / other.value;
        return new Scalar(div);
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
