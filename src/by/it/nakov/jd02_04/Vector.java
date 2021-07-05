package by.it.nakov.jd02_04;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(String strVector) {
        String[] strVectorArr = strVector.replace('{', ' ')
                .replace('}', ' ')
                .trim().split(",\\s*");
        value = new double[strVectorArr.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(strVectorArr[i]);
        }
    }

    Vector(Vector vector) {
        this(vector.value);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];
            }
            return new Vector(res);
        } else return super.add(other);
    }


    @Override
    public String toString() {
        return Arrays.toString(value)
                .replace('[', '{')
                .replace(']', '}');
    }
}


