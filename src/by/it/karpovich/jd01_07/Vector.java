package by.it.karpovich.jd01_07;

import java.util.Arrays;

class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = value = Arrays.copyOf(value,value.length);
    }

    public Vector (Vector vector){
        this.value = vector.value;
    }

    public Vector(String strVector) {
        String line = strVector.replaceAll("[{}]", "");
        String[] vector = line.split(",");
        this.value = new double[vector.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(vector[i]);
        }
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

