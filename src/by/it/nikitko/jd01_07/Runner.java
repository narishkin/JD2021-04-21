package by.it.nikitko.jd01_07;



public class Runner {
    public static void main(String[] args) {

        System.out.println("Scalar variables");

        var doubleVar = new Scalar(3.14);
        System.out.println(doubleVar);

        var stringVar = new Scalar("123.456");
        System.out.println(stringVar);

        var scalarVar = new Scalar(stringVar);
        System.out.println(scalarVar);


        System.out.println("Vector variables");

        double[] array = {1.0, 2.0, 4.0};
        var arrayVar = new Vector(array);
        System.out.println(arrayVar);

        String arrayString= "{1.0, 2.0, 4.0}";
        var arrayStringVar = new Vector(arrayString);
        System.out.println(arrayVar);

        var vectorVar= new Vector(arrayStringVar);
        System.out.println(vectorVar);


        System.out.println("Matrix variables");

        double[][]matrix = { { 1.0, 2.0 }, { 3.0, 4.0 } };

        var matrixArrayVar = new Matrix(matrix);
        System.out.println(matrixArrayVar);


        String matrixString ="{{1,2},{3,4}}";

        var matrixStringVar = new Matrix (matrixString);
        System.out.println(matrixStringVar);

        var matrixVar = new Matrix(matrixArrayVar);
        System.out.println(matrixVar);

    }
}
