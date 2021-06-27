package by.it._classwork_.jd02_04;

import java.util.Arrays;

class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(String stringVar) {
        String[] values = stringVar
                .replace("{", "")
                .replace("}", "")
                .replace(" ", "").split(",");
        this.value = new double[values.length];
        for (int i = 0, valuesLength = values.length; i < valuesLength; i++) {
            value[i] = Double.parseDouble(values[i]);
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] firstValue = Arrays.copyOf(value, value.length);
            double secondValue = ((Scalar) other).getValue();
            for (int i = 0; i < firstValue.length; i++) {
                firstValue[i] += secondValue;
            }
            return new Vector(firstValue);
        } else if (other instanceof Vector) {
            double[] firstValue = Arrays.copyOf(value, value.length);
            double[] secondValue = ((Vector) other).value;
            if (firstValue.length!=secondValue.length){
                throw new CalcException("incorrect size of vectors");
            }
            for (int i = 0; i < firstValue.length; i++) {
                firstValue[i] += secondValue[i];
            }
            return new Vector(firstValue);
        }
        return super.add(other);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            out.append(delimiter);
            out.append(element);
            delimiter = ", ";
        }
        out.append("}");
        return out.toString();
    }
}
