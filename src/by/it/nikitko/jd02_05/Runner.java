package by.it.nikitko.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TimeUtils timeUtils = new TimeUtils();
        ResourceManager manager = ResourceManager.INSTANCE;
        Locale locale = new Locale("en", "US");
        manager.setLocale(locale);

        if (args.length == 2) {
            locale = new Locale(args[0], args[1]);
            manager.setLocale(locale);
        }

        printMessages(timeUtils, manager, locale);
        switchLocale(scanner, timeUtils, manager, locale);
    }

    private static void switchLocale(Scanner scanner, TimeUtils timeUtils, ResourceManager manager, Locale locale) {
        String enteredString;
        while (!(enteredString = scanner.nextLine()).equals("end")) {
            switch (enteredString) {
                case ("ru"):
                    locale = new Locale("ru", "RU");
                    manager.setLocale(locale);
                    break;

                case ("en"):
                    locale = new Locale("en", "US");
                    manager.setLocale(locale);
                    break;

                case ("be"):
                    locale = new Locale("be", "BY");
                    manager.setLocale(locale);
                    break;
            }
            printMessages(timeUtils, manager, locale);
        }
    }

    private static void printMessages(TimeUtils timeUtils, ResourceManager manager, Locale locale) {
        System.out.println(manager.get(Messages.WELCOME));
        System.out.println(manager.get(Messages.QUESTION));
        System.out.println(manager.get(User.FIRST_NAME));
        System.out.println(manager.get(User.LAST_NAME));
        System.out.println(timeUtils.getDate(locale));
    }
}