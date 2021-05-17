package by.it.nikitko.jd01_07;

public class Runner {
    public static void main(String[] args) {

        var doubleVar = new Scalar(3.14);
        System.out.println(doubleVar);

        var stringVar = new Scalar("123.456");
        System.out.println(stringVar);

        var scalarVar = new Scalar(stringVar);
        System.out.println(scalarVar);



        double[] array = {1.0, 2.0, 4.0};
        var arrayVar = new Vector(array);
        System.out.println(arrayVar);

        String arrayString= "{1.0, 2.0, 4.0}";
        var arrayStringVar = new Vector(arrayString);
        System.out.println(arrayVar);

        var vectorVar= new Vector(arrayStringVar);
        System.out.println(vectorVar);


    }
}
