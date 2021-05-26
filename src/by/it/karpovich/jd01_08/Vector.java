package by.it.karpovich.jd01_08;


import java.util.Arrays;

class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
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

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] firstValue = Arrays.copyOf(value, value.length);
            double secondValue = ((Scalar) other).getValue();
            for (int i = 0; i < firstValue.length; i++) {
                firstValue[i] += secondValue;
            }
            return new Vector(firstValue);
        } else if (other instanceof Vector) {
            double[] firstValue = Arrays.copyOf(value, value.length);
            double[] secondValue = ((Vector) other).value;
            for (int i = 0; i < firstValue.length; i++) {
                firstValue[i] += secondValue[i];
            }
            return new Vector(firstValue);
        }
        return super.add(other);
    }


    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] firstValue = Arrays.copyOf(value, value.length);
            double secondValue = ((Scalar) other).getValue();
            for (int i = 0; i < firstValue.length; i++) {
                firstValue[i] -= secondValue;
            }
            return new Vector(firstValue);
        } else if (other instanceof Vector) {
            double[] firstValue = Arrays.copyOf(value, value.length);
            double[] secondValue = ((Vector) other).value;
            for (int i = 0; i < firstValue.length; i++) {
                firstValue[i] -= secondValue[i];
            }
            return new Vector(firstValue);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] firstValue = Arrays.copyOf(value, value.length);
            double secondValue = ((Scalar) other).getValue();
            for (int i = 0; i < firstValue.length; i++) {
                firstValue[i] *= secondValue;
            }
            return new Vector(firstValue);
        } else if (other instanceof Vector) {
            double[] firstValue = Arrays.copyOf(value, value.length);
            double[] secondValue = ((Vector) other).value;
            int mul = 0;
            for (int i = 0; i < firstValue.length; i++) {
                mul += firstValue[i] * secondValue[i];
            }
            return new Scalar(mul);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] firstValue = Arrays.copyOf(value, value.length);
            double secondValue = ((Scalar) other).getValue();
            if (secondValue == 0) {
                System.out.println("Деление невозможно");
            } else {
                for (int i = 0; i < firstValue.length; i++) {
                    firstValue[i] /= secondValue;
                }
            }
            return new Vector(firstValue);
        }
        if (other instanceof Vector) {
            System.out.println("Деление невозможно");
        }
        return super.div(other);
    }
}

