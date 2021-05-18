package by.it.nikitko.jd01_07;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String strVector) {
        this.value = Arrays.stream(strVector.substring(1, strVector.length()-1).split(","))
                .map(String::trim).mapToDouble(Double::parseDouble).toArray();

        }





    public String toString() {
        StringBuilder out = new StringBuilder();
        String delimiter = ("");
        out.append("{");
        for (double item : value) {
            out.append(delimiter);
            out.append(item);
            delimiter = (", ");
        }
        out.append("}");
        return out.toString();
    }
}
 
