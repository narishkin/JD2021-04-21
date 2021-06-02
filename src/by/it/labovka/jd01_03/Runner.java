package by.it.labovka.jd01_03;

import java.util.Scanner;

public  class Runner {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String str = sc.nextLine();
       InOut.getArray(str);
       InOut.printArray(InOut.getArray(str));
    }
}
