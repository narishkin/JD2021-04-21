package by.it._classwork_.jd01_07;

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

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
