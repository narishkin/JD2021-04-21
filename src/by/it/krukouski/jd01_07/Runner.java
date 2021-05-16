package by.it.krukouski.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var val = new Scalar(3.145);
        System.out.println(val);
        Scalar scalarVar = new Scalar(3.145);
        Var val1 = new Scalar(scalarVar);
        System.out.println(val1);
        Var val2 = new Scalar("3.145");
        System.out.println(val2);
        System.out.println();


        double[] array = new double[]{1.0, 2.0, 4.0};
        Var vector = new Vector(array);
        System.out.println(vector);
        Vector newVector1 = new Vector(array);
        Var vector1 = new Vector((newVector1));
        System.out.println(vector1);
        Var vector2 = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(vector2);
        System.out.println();

        double[][] doubleArray = new double[][]{{1.0, 2.0},{3.0, 4.0}};
        Var matrix = new Matrix(doubleArray);
        System.out.println(matrix);
        Matrix newMatrix = new Matrix(doubleArray);
        Var matrix1 = new Matrix(newMatrix);
        System.out.println(matrix1);
        Var matrix2= new Matrix("{{1.0,2.0},{3.0,4.0}}");
        System.out.println(matrix2);


    }

}
