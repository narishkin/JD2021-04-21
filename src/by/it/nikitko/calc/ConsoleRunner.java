package by.it.nikitko.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    public static ResourceManager manager = ResourceManager.INSTANCE;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String enteredString;
        Parser parser = new Parser();
        VarRepo.loadVars();
        Printer printer = new Printer();
        setLocalFromArgs(args);


        while (!(enteredString = input.nextLine()).equals("end")) {
            try {
                if (enteredString.equals("printvar")) {
                    System.out.println(VarRepo.getVars());
                } else if (enteredString.equals("sortvar")) {
                    System.out.println(VarRepo.getVars().entrySet());
                } else if (enteredString.equals("en") | enteredString.equals("ru") | enteredString.equals("be")) {
                    switchLocale(enteredString);
                } else {
                    Var result = parser.calc(enteredString);
                    printer.print(result);
                }
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
            VarRepo.saveVars();

        }
    }

    private static void setLocalFromArgs(String[] args) {
        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            manager.setLocale(locale);
        }
    }

    private static void switchLocale(String enteredString) {
        switch (enteredString) {
            case ("ru") -> {
                Locale locale = new Locale("ru", "RU");
                manager.setLocale(locale);
                System.out.println(ConsoleRunner.manager.get(Messages.LANGUAGE_IS_SET));
            }
            case ("en") -> {
                Locale locale = new Locale("en", "US");
                manager.setLocale(locale);
                System.out.println(ConsoleRunner.manager.get(Messages.LANGUAGE_IS_SET));
            }
            case ("be") -> {
                Locale locale = new Locale("be", "BY");
                manager.setLocale(locale);
                System.out.println(ConsoleRunner.manager.get(Messages.LANGUAGE_IS_SET));
            }
        }

    }

}
