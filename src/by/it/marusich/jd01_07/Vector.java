package by.it.marusich.jd01_07;

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
        Arrays.toString(value);
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
