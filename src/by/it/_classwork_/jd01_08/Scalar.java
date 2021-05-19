package by.it._classwork_.jd01_08;

class Scalar extends Var {

    private double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(String stringValue) {
        this.value = Double.parseDouble(stringValue);
    }

    public Scalar(Scalar otherScalar) {
        value = otherScalar.value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double result = this.value + ((Scalar) other).value;
            return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double result = this.value - ((Scalar) other).value;
            return new Scalar(result);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double result = this.value * ((Scalar) other).value;
            return new Scalar(result);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double secondOperandValue = ((Scalar) other).value;
            if (secondOperandValue == 0) {
                System.out.println("Division by zero");
                return null; //TODO Exception
            }
            double result = this.value / secondOperandValue;
            return new Scalar(result);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
