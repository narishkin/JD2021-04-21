package by.it.nikitko.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        String enteredString;
        Parser parser = new Parser();
        VarRepo.loadVars();
        Printer printer = new Printer();

        Locale locale = new Locale("en", "US");
        ResourceManager manager = ResourceManager.INSTANCE;
        manager.setLocale(locale);

        if (args.length == 2) {
            locale = new Locale(args[0], args[1]);
            manager.setLocale(locale);
        }




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
