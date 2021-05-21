package by.it.krukouski.jd01_07;

public class Vector extends Var{

    private final double [] ARRAY;

    public Vector(double[] value){
        ARRAY =value;
    }

    public Vector(Vector vector){
        ARRAY= vector.ARRAY;
    }

    public Vector(String stringVector){
        String line = stringVector.replaceAll("[{}]", "");
        String[] vector = line.split(",");
        this.ARRAY=new double[vector.length];
        for (int i = 0; i < ARRAY.length; i++) {
            ARRAY[i]=Double.parseDouble(vector[i]);
        }
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{");
        String delimiter = "";
        for (double elementArray:ARRAY) {
            string.append(delimiter);
            string.append(elementArray);
            delimiter = ", ";
        }
        string.append("}");
        return string.toString();
    }
}
