package by.it.mogonov.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var var1 = new Scalar(3.1415);
        System.out.println(var1.toString());
        Scalar var2=new Scalar("3.1415");
        System.out.println(var2.toString());
        Var var3=new Scalar(var2);
        System.out.println(var2.toString());

        Var vector1 = new Vector(new double[]{1.0, 2.0, 4.0});
        System.out.println(vector1.toString());
        Vector vector2 = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(vector2);
        Var vector3 = new Vector(vector2);
        System.out.println(vector3.toString());


      // Var matrix1 = new Matrix(new double[][]{{ 1.0, 2.0 },{ 3.0, 4.0 }});
        //System.out.println(matrix1.toString());


    }
}


