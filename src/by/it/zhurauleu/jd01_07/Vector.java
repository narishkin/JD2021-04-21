package by.it.zhurauleu.jd01_07;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String strVector) {
        String[] strArr = strVector.split("[/{, }]+");
        strArr = Arrays.copyOfRange(strArr, 1, strArr.length);
        double[] array = new double[strArr.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(strArr[i]);
        }
        this.value = array;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            output.append(delimiter);
            output.append(value[i]);
            delimiter = ", ";
        }
        output.append("}");
        return output.toString();
    }
}

