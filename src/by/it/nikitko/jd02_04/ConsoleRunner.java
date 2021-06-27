package by.it.nikitko.jd02_04;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        String enteredString;
        Parser parser = new Parser();
        VarRepo.loadVars();
        Printer printer = new Printer();


        while (!(enteredString=input.nextLine()).equals("end")){

            try {
               Var result = parser.calc(enteredString);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
            VarRepo.saveVars();

        }
    }

}
