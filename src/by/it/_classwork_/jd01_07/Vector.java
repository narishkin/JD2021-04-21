package by.it._classwork_.jd01_07;

import java.util.Arrays;

class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
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
