package by.it.sapazhkou.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar scalar = new Scalar(3.1415);
        System.out.println(scalar.toString());
        Scalar scalar1 = new Scalar("3.1415");
        System.out.println(scalar.toString());
        Scalar scalar2 = new Scalar(scalar1);
        System.out.println(scalar.toString());
        Vector vector = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(vector.toString());
        double[] test = {1.0, 2.0, 4.0};
        Vector vector1 = new Vector(test);
        System.out.println(vector1.toString());
        Vector vector2 = new Vector(vector1);
        System.out.println(vector2.toString());
        double[][] test2 = { { 1.0, 2.0 },  { 3.0, 4.0 } };
        Matrix matrix = new Matrix(test2);
        System.out.println(matrix.toString());
        Matrix matrix1 = new Matrix(matrix);
        System.out.println(matrix1.toString());
        Matrix matrix2 = new Matrix(" { { 1.0, 2.0 },  { 3.0, 4.0 } }");
        System.out.println(matrix2.toString());


    }
}
