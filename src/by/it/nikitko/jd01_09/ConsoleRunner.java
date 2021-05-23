package by.it.nikitko.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        String string;
        Parser parser = new Parser();
        Printer printer = new Printer();


        while (!(string=input.nextLine()).equals("end")){
            Var result = parser.calc(string);
            printer.print(result);

        }
    }

}
