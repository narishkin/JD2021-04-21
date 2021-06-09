package by.it.marusich.jd01_07;

import java.util.Arrays;

public class Vector {
    private double[]value;

    public Vector (double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimitter = "";
        for (double element : value)
        {
            out.append(delimitter);
            out.append(element);
            delimitter = ", ";
        }
        out.append("}");
         return out.toString();
    }
}
