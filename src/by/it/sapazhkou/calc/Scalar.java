package by.it.sapazhkou.calc;

class Scalar extends Var {

    double value;

    public double getValue() {
        return value;
    }

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(String strScalar) {
        this.value = Double.valueOf(strScalar);
    }

    public Scalar(Scalar scalar){
        this.value = scalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) {
        if(other instanceof Scalar) {
            double result = this.value + ((Scalar) other).value;
            return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar) {
            double result = this.value - ((Scalar) other).value;
            return new Scalar(result);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Scalar) {
            double result = this.value * ((Scalar) other).value;
            return new Scalar(result);
        }

        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar) {
            if(((Scalar) other).value == 0){
                System.out.println("Деление на ноль");
            }
            double result = this.value / ((Scalar) other).value;
            return new Scalar(result);
        }
        return other.div(this);
    }
}
