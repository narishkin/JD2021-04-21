package by.it._classwork_.jd01_07;

class Runner {
    public static void main(String[] args) {
        Var var1 = new Scalar(123.456);
        System.out.println(var1.toString());
        Scalar var2 = new Scalar("654.321");
        System.out.println(var2.toString());
        Var var3 = new Scalar(var2);
        System.out.println(var2.toString());
        double[] array = {1, 2, 3, 4, 6};
        Var vector4=new Vector(array);
        System.out.println(vector4);

    }
}
