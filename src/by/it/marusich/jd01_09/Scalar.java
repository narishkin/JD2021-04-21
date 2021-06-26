package by.it.marusich.jd01_09;


public class Scalar extends Var {
    private final double VALUE;

    public Scalar(double value) {
        this.VALUE = value;
    }

    public Scalar(Scalar scalar) {
        VALUE = scalar.VALUE;

    }

    public Scalar(String stringScalar) {
        VALUE = Double.parseDouble(stringScalar);
    }

    public double getScalar(){
        return VALUE;
    }

    @Override
    public String toString() {
        return Double.toString(VALUE);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double result = this.VALUE + ((Scalar) other).VALUE;
            return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double result = this.VALUE - ((Scalar) other).VALUE;
            return new Scalar(result);
        }
        return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double result = this.VALUE * ((Scalar) other).VALUE;
            return new Scalar(result);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            if (((Scalar) other).VALUE == 0){
                System.out.println("Division by zero");
                return null;
            }
            double result = this.VALUE / ((Scalar) other).VALUE;
            return new Scalar(result);
        }
        return super.div(other);
    }
}

