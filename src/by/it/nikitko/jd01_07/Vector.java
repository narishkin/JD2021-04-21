package by.it.nikitko.jd01_07;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

class Vector extends Var {
    private double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String strVector) {
        String[] split = strVector.substring(1, strVector.length() - 1).split(",");
        Stream<String> stream = Arrays.stream(split);
        Stream<String> streamTrimmed = stream.map(String::trim);
        DoubleStream doubleStream = streamTrimmed.mapToDouble(Double::parseDouble);
        this.value = doubleStream.toArray();
    }


    @Override
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
 
