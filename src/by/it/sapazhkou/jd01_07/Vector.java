package by.it.sapazhkou.jd01_07;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Vector extends Var {

    double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(String strVector){

        String[] arrayElement = strVector.split("[^\\.\\d]+");
        value = new double[arrayElement.length-1];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.valueOf(arrayElement[i+1]);
        }
        this.value = value;
    }
    public Vector(Vector vector){
        this.value = vector.value;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            sb.append(Double.toString(value[i]));
        if (i< value.length-1){
            sb.append(", ");
            }
        }

        sb.append("}");

        return sb.toString();
    }
}
