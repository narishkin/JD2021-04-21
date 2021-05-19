package by.it.nikitko.jd01_07;

class Scalar extends Var {

    private double value;

    public Scalar(double value) {
        this.value = value;
    }

    public  Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    public Scalar(String string) {

        this.value = Double.parseDouble(string);
    }

    @Override
    public String toString() {

        return Double.toString(value);
    }

}
