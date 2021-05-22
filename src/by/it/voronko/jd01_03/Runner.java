package by.it.voronko.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
     Scanner scanner=new Scanner(System.in);
     String str=scanner.nextLine();
     InOut.getArray(str);
     double[] array= InOut.getArray(str);
     InOut.printArray(array);
     InOut.printArray(array,"Z",3);
    }

}
