package by.it.naryshkin.jd02_05.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    static final String KEY_STOP_APP = "end";
    public  ResourceManager resourceManager = ResourceManager.INSTANCE;

    public static void main(String[] args) {
        ConsoleRunner consoleRunner = new ConsoleRunner();
        Printer printer = new Printer();
        Parser parser = new Parser();
        VarRepo.loadVars();
        Scanner sc = new Scanner(System.in);
        String line;
        for (; ; ) {
            line = sc.nextLine();
            line = consoleRunner.localeSelector(line);
            if (line.isEmpty()) continue;
            if (!line.equals(KEY_STOP_APP)) {
                try {
                    Var result = parser.calc(line);
                    printer.print(result);
                } catch (CalcException e) {
                    printer.print(e);
                }
            } else {
                VarRepo.saveVars();
                break;
            }
        }
    }

    private  String localeSelector(String line) {
        Locale locale;
        switch (line) {
            case "en": {
                locale = new Locale("en", "US");
                resourceManager.set(locale);
                System.out.println("English");
                return "";
            }
            case "be": {
                locale = new Locale("be", "BY");
                resourceManager.set(locale);
                System.out.println("Белорусский");
                return "";

            }
            case "ru": {
                locale = new Locale("ru", "RU");
                resourceManager.set(locale);
                System.out.println("Русский");
                return "";
            }
            default:
                return line;
        }
    }
}
