package by.it.marusich.jd01_08;



import java.util.Arrays;

public class Vector extends Var {

    private final double[] ARRAY;

    public Vector(double[] value) {
        ARRAY = value;
    }

    public Vector(Vector vector) {
        ARRAY = vector.ARRAY;
    }

    public double[] getARRAY() {
        return ARRAY;
    }

    public Vector(String stringVector) {
        String line = stringVector.replaceAll("[{}]", "");
        String[] vector = line.split(",");
        this.ARRAY = new double[vector.length];
        for (int i = 0; i < ARRAY.length; i++) {
            ARRAY[i] = Double.parseDouble(vector[i]);
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] firstVector = Arrays.copyOf(ARRAY, ARRAY.length);
            double scalar = ((Scalar) other).getScalar();
            for (int i = 0; i < firstVector.length; i++) {
                firstVector[i] += scalar;
            }
            return new Vector(firstVector);
        } else if (other instanceof Vector) {
            double[] firstVector = Arrays.copyOf(ARRAY, ARRAY.length);
            double[] secondVector = ((Vector) other).ARRAY;
            if (firstVector.length == secondVector.length) {
                for (int i = 0; i < firstVector.length; i++) {
                    firstVector[i] += ((Vector) other).ARRAY[i];
                }
            } else {
                System.out.println("Different length Vectors");
                return null;
            }
            return new Vector(firstVector);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] firstVector = Arrays.copyOf(ARRAY, ARRAY.length);
            double scalar = ((Scalar) other).getScalar();
            for (int i = 0; i < firstVector.length; i++) {
                firstVector[i] -= scalar;
            }
            return new Vector(firstVector);
        } else if (other instanceof Vector) {
            double[] firstVector = Arrays.copyOf(ARRAY, ARRAY.length);
            double[] secondVector = ((Vector) other).ARRAY;
            if (firstVector.length == secondVector.length) {
                for (int i = 0; i < firstVector.length; i++) {
                    firstVector[i] -= ((Vector) other).ARRAY[i];
                }
            } else {
                System.out.println("Different length Vectors");
                return null;
            }
            return new Vector(firstVector);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] firstVector = Arrays.copyOf(ARRAY, ARRAY.length);
            double scalar = ((Scalar) other).getScalar();
            for (int i = 0; i < firstVector.length; i++) {
                firstVector[i] *= scalar;
            }
            return new Vector(firstVector);
        } else if (other instanceof Vector) {
            double[] firstVector = Arrays.copyOf(ARRAY, ARRAY.length);
            double[] secondVector = ((Vector) other).ARRAY;
            int sum = 0;
            if (firstVector.length == secondVector.length) {
                for (int i = 0; i < firstVector.length; i++) {
                    sum += firstVector[i] * secondVector[i];
                }
            } else {
                System.out.println("Different length Vectors");
                return null;
            }
            return new Scalar(sum);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] firstVector = Arrays.copyOf(ARRAY, ARRAY.length);
            double scalar = ((Scalar) other).getScalar();
            if (scalar == 0) {
                System.out.println("Division by zero");
            } else {
                for (int i = 0; i < firstVector.length; i++) {
                    firstVector[i] /= scalar;
                }
            }
            return new Vector(firstVector);
        }

        if (other instanceof Vector) {
            System.out.println("Division impossible");
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{");
        String delimiter = "";
        for (double elementArray : ARRAY) {
            string.append(delimiter);
            string.append(elementArray);
            delimiter = ", ";
        }
        string.append("}");
        return string.toString();
    }
}
