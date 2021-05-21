package by.it.stain.jd01_07;

 class Runner {
     public static void main(String[] args) {
         Var variable = new Scalar(3.14);
         double [] array = {1,2,3,4,5,6};
         Var vector = new Vector(array);
         double [][] matix = { { 1.0, 2.0 }, { 3.0, 4.0 } };
         Var matrix = new Matrix(matix);
         System.out.println(variable);
         System.out.println(vector);
         System.out.println(matrix);





     }
}
