package by.it.naryshkin.jd01_10.calc;

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
        Pattern p1 = Pattern.compile("(\\d\\.\\d)|(\\d)");
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
    public Var add(Scalar other) {
        double[] result = Arrays.copyOf(value, value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] + other.getValue();
        }
        return new Vector(result);
    }

    @Override
    public Var add(Vector other) {
        double[] result = Arrays.copyOf(value, value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] + other.value[i];
        }
        return new Vector(result);
    }


    @Override
    public Var sub(Scalar other) {
        double[] result = Arrays.copyOf(value, value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] - other.getValue();
        }
        return new Vector(result);
    }

    @Override
    public Var sub(Vector other) {
        double[] result = Arrays.copyOf(value, value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] - other.value[i];
        }
        return new Vector(result);
    }


    @Override
    public Var mul(Scalar other) {
        double[] result = Arrays.copyOf(value, value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] * other.getValue();
        }
        return new Vector(result);
    }

    @Override
    public Var mul(Vector other) {
        double result = 0;
        for (int i = 0; i < value.length; i++) {
            result = result + value[i] * other.value[i];
        }
        return new Scalar(result);
    }


    @Override
    public Var div(Scalar other) {
        if (other.getValue() == 0) {
            System.out.println("Division by zero");
            return null;
        }
        double[] result = Arrays.copyOf(value, value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] / other.getValue();
        }
        return new Vector(result);
    }



    @Override
    public Var div(Vector other) {
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
