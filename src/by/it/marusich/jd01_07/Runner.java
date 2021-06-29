package by.it.marusich.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar v0 = new Scalar(3.1415);
        Var v1 = new Scalar(3.1415);
        Var v2 = new Scalar(v0);
        Var v3 = new Scalar("3.1415");
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);


        Vector vector0 = new Vector(new double[]{15.15, -2.0, 6.5});
        Var v4 = new Vector(new double[]{1.0, 2.0, 4.0});
        Var v5 = new Vector(vector0);
        Var v6 = new Vector("{1.0,2.0,4.0}");


        System.out.println(v4);
        System.out.println(v5);
        System.out.println(v6);

        Matrix matrix0 = new Matrix(new double[][]{{1, 2}, {3, 4}, {3, 4}});
        Var v7 = new Matrix(new double[][]{{1.0, 2.0}, {8.0, 4.0}, {3.0, 1.0}});
        Var v8 = new Matrix(matrix0);
        Var v9 = new Matrix("{{ 1.0, 2.0},{ 3.0, 4.0 },{ 5.0, 6.0} ,{ 7.0, 8.0 },{ 9.0, 10.0}}");
        System.out.println(matrix0);
        System.out.println(v9);

    }
}