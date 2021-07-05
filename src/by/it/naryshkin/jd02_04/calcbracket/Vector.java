package by.it.naryshkin.jd02_04.calcbracket;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {

    double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String strVector) {
        StringBuilder sb = new StringBuilder(strVector);
        Pattern p1 = Pattern.compile(Patterns.SCALAR);
        Matcher m1 = p1.matcher(strVector);
        int vectorLength = 0;
        while (m1.find()) {
            vectorLength++;
        }
        value = new double[vectorLength];
        m1.reset();
        int i = 0;
        while (m1.find()) {
            value[i] = Double.parseDouble(m1.group());
            i++;
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            if (this.value.length!=((Vector) other).value.length){
                throw new CalcException("длина векторов неодинакова");
            }
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + ((Vector) other).value[i];
            }
            return new Vector(result);

        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            if (this.value.length!=((Vector) other).value.length){
                throw new CalcException("длина векторов неодинакова");
            }
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - ((Vector) other).value[i];
            }
            return new Vector(result);
        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            if (this.value.length!=((Vector) other).value.length){
                throw new CalcException("длина векторов неодинакова");
            }
            double result = 0;
            for (int i = 0; i < value.length; i++) {
                result = result + value[i] * ((Vector) other).value[i];
            }
            return new Scalar(result);
        } else {
            return super.mul(other);
        }

    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() == 0) {
                throw new CalcException("Division by zero");
            }
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] / ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            return super.div(other);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (double valueElement : value) {
            sb.append(valueElement);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("}");

        return sb.toString();
    }
}
