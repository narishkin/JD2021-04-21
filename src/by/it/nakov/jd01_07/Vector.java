package by.it.nakov.jd01_07;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value,0,this.value,0,value.length);
    }

    Vector(String strVector) {
        String[] strVectorArr = strVector
                .replace('{',' ').replace('}', ' ')
                .trim().split(",\\s*");
        value = new double[strVectorArr.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(strVectorArr[i]);
        }
    }

    Vector(Vector vector) {
        this (vector.value);
    }

    @Override
    public String toString() {
        StringBuilder ab = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            ab.append(delimiter).append(element);
            delimiter = ", ";
        }
        ab.append("}");
        return ab.toString();
    }
}


