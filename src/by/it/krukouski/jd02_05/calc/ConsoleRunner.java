package by.it.krukouski.jd02_05.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    static final String KEY_WORD = "end";

    public static void main(String[] args) throws CalcException {
        ResMan manager = ResMan.INSTANCE;
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose language: be en ru");
        String language = scanner.nextLine();
        switch (language) {
            case "ru":
                manager.set(new Locale("ru", "RU"));
                break;
            case "en":
                manager.set(new Locale("en", "US"));
                break;
            case "be":
                manager.set(new Locale("be", "BY"));
                break;
        }
        System.out.println(ResMan.INSTANCE.get(Errors.keyWord));
        for (; ; ) {
            String expression = scanner.nextLine();
            if (!expression.equals(KEY_WORD)) {
                try {


                    Var var = parser.calc(expression);
                    printer.print(var);
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                break;
            }
        }


    }
}
