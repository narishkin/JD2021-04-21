package by.it.mogonov.jd01_07;

import java.util.Arrays;


public class Vector extends Var {

    private double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }


    Vector(Vector vector) {
        value = vector.value;

    }

    public Vector(String strVector) {

        String[] token = strVector.replaceAll("[ {}]", "").split(",");
        this.value = new double[token.length];
        for (int i = 0; i < token.length; i++) {
            this.value[i] = Double.valueOf(token[i]);
        }

    }


















    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            stb.append(delimiter);
            stb.append(element);
            delimiter = ", ";
        }
         stb.append('}');
        return stb.toString();
    }
}
