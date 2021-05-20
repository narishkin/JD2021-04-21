package by.it.nikitko.jd01_08;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

class Vector extends by.it.nikitko.jd01_08.Var {
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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] addRes = Arrays.copyOf(value, value.length);
            for (int i = 0; i < addRes.length; i++) {
                addRes[i] += ((Scalar) other).getValue();
            }
            return new Vector(addRes);
        } else if (other instanceof Vector) {
            double[] addRes = Arrays.copyOf(value, value.length);
            for (int i = 0; i < addRes.length; i++) {
                addRes[i] = addRes[i] + ((Vector) other).value[i];
            }
            return new Vector(addRes);

        }
        else{
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
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
 
