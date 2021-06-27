package by.it.nikitko.jd02_04;

class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    public Scalar(String string) {
        this.value = Double.parseDouble(string);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        } else {
            return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        } else {
            return new Scalar(-1).mul(other).add(this);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);
        } else {
            return other.mul(this);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double denominator = ((Scalar) other).value;
            if (denominator == 0) {
                throw new CalcException("Division by zero");
            }
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        }
        if (other instanceof Vector) {
            throw new CalcException("Opretion Scalar/Vector is impossible");
        }
        else {
            return other.div(this);
        }
    }

    @Override
    public String toString() {

        return Double.toString(value);
    }

}
