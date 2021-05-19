package by.it.sapazhkou.jd01_07;

class Scalar extends Var{

    double value;

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
}
