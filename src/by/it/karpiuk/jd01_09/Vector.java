package by.it.karpiuk.jd01_09;

import java.util.Arrays;

class Vector extends Var {
    private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String stringVector) {
        String line = stringVector.replaceAll("[{}]", "");
        String[] vector = line.split(",");
        this.value = new double[vector.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(vector[i]);
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] firsValue = Arrays.copyOf(value, value.length);
            double secondValue = ((Scalar) other).getValue();
            for (int i = 0; i < firsValue.length; i++) {
                firsValue[i] += secondValue;
            }
            return new Vector(firsValue);
        } else if (other instanceof Vector){
            double[] firstValue = Arrays.copyOf(value, value.length);
            double[] secondValue = ((Vector) other).value;
            for (int i = 0; i < firstValue.length; i++) {
                firstValue[i]+=secondValue[i];
            }
            return new Vector(firstValue);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){

            double[] firsValue = Arrays.copyOf(value, value.length);
            double secondValue = ((Scalar) other).getValue();
            for (int i = 0; i < firsValue.length; i++) {
                firsValue[i] -= secondValue;
            }
            return new Vector(firsValue);
        } else if (other instanceof Vector){
            double[] firstValue = Arrays.copyOf(value, value.length);
            double[] secondValue = ((Vector) other).value;
            for (int i = 0; i < firstValue.length; i++) {
                firstValue[i]-=secondValue[i];
            }
            return new Vector(firstValue);

        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double[] firsValue = Arrays.copyOf(value, value.length);
            double secondValue = ((Scalar) other).getValue();
            for (int i = 0; i < firsValue.length; i++) {
                firsValue[i] *= secondValue;
            }
            return new Vector(firsValue);
        } else if (other instanceof Vector) {
            double[] firstValue = Arrays.copyOf(value, value.length);
            double[] secondValue = ((Vector) other).value;
            double result = 0;
            if (firstValue.length == secondValue.length) {
                for (int i = 0; i < firstValue.length; i++) {
                    result += firstValue[i] * secondValue[i];
                }
                }else {
                    System.out.println("Векторы не совпадают по длине.");
                    return null;
                }
                return new Scalar(result);
            }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {

            double[] firsValue = Arrays.copyOf(value, value.length);
            double value = ((Scalar) other).getValue();
            if (value == 0) {
                System.out.println("Деление на 0");
            } else {
                for (int i = 0; i < firsValue.length; i++) {
                    firsValue[i] /= value;
                }
            }
            return new Vector(firsValue);
        }

        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimeter = "";
        for (double element : value) {
            out.append(delimeter);
            out.append(element);
            delimeter = ", ";

        }
        out.append("}");
        return out.toString();
    }
}
