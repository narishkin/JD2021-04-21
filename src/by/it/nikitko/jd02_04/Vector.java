package by.it.nikitko.jd02_04;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

class Vector extends Var {
    private double[] value;

    public double[] getValue() {
        return value;
    }

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
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] addRes = Arrays.copyOf(value, value.length);
            for (int i = 0; i < addRes.length; i++) {
                addRes[i] += ((Scalar) other).getValue();
            }
            return new Vector(addRes);
        } else if (other instanceof Vector) {
            double[] addRes = Arrays.copyOf(value, value.length);
            double[] secondValue = ((Vector) other).value;

            if (addRes.length!=secondValue.length){
                throw new CalcException("incorrect size of vectors");
            }
            for (int i = 0; i < addRes.length; i++) {
                addRes[i] = addRes[i] + ((Vector) other).value[i];
            }
            return new Vector(addRes);

        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] subRes = Arrays.copyOf(value, value.length);
            for (int i = 0; i < subRes.length; i++) {
                subRes[i] -= ((Scalar) other).getValue();
            }
            return new Vector(subRes);
        } else if (other instanceof Vector) {
            double[] subRes = Arrays.copyOf(value, value.length);
            double[] secondValue = ((Vector) other).value;
            if (subRes.length!=secondValue.length) {
                throw new CalcException("incorrect size of vectors");
            }
            for (int i = 0; i < subRes.length; i++) {
                subRes[i] = subRes[i] - ((Vector) other).value[i];
            }
            return new Vector(subRes);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] mulRes = Arrays.copyOf(value, value.length);
            for (int i = 0; i < mulRes.length; i++) {
                mulRes[i] *= ((Scalar) other).getValue();
            }
            return new Vector(mulRes);
        } else if (other instanceof Vector) {
            double result = 0;
            double[] mulRes = Arrays.copyOf(value, value.length);
            for (int i = 0; i < mulRes.length; i++) {
                mulRes[i] = mulRes[i] * ((Vector) other).value[i];
                result += mulRes[i];
            }
            return new Scalar(result);
        } else {
            return super.mul(other);
        }
    }


    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double denominator = ((Scalar) other).getValue();
            if (denominator == 0) {
                throw new CalcException("Division by zero");
            }
            double[] divRes = Arrays.copyOf(value, value.length);
            for (int i = 0; i < divRes.length; i++) {
                divRes[i] /= ((Scalar) other).getValue();
            }
            return new Vector(divRes);
        } else {
            return super.div(other);
        }
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
 
