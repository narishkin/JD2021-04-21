package by.it.karpovich.jd01_08;

import java.util.Arrays;

public class Matrix extends Var {

    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value = Arrays.copyOf(value,value.length);
    }

    public Matrix (Matrix matrix){
        this.value = matrix.value;
    }



    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            out.append("{");
            for (int j = 0; j < value[i].length; j++) {
                if (j == value[i].length - 1) {
                    out.append(value[i][j]);
                    out.append("}");
                } else {
                    out.append(value[i][j]);
                    out.append(", ");
                }
            }
            if (i < value.length - 1){
                out.append(", ");
            }
            if (i == value.length - 1){
                out.append("}");
            }
        }
        return out.toString();
    }

    @Override
    public Var add(Var other) {
        return null;
    }

    @Override
    public Var sub(Var other) {
        return null;
    }

    @Override
    public Var mul(Var other) {
        return null;
    }

    @Override
    public Var div(Var other) {
        return null;
    }
}
