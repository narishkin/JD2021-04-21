package by.it.naryshkin.jd02_05;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ResourceManager resourceManager = ResourceManager.INSTANCE;
        Locale locale = Locale.getDefault();
        if (args.length == 2) {
            locale = new Locale(args[0], args[1]);
            resourceManager.set(locale);
        }
        printer(resourceManager, locale);
        localeSwitcher(resourceManager, locale);
    }

    private static void localeSwitcher(ResourceManager resourceManager, Locale locale) {
        Scanner sc = new Scanner(System.in);
        String s;
        while (!(s = sc.nextLine()).equals("end")) {
            switch (s) {
                case "ru": {
                    locale = new Locale("ru", "RU");
                    resourceManager.set(locale);
                    break;
                }
                case "be": {
                    locale = new Locale("be", "BY");
                    resourceManager.set(locale);
                    break;
                }
                case "en": {
                    locale = new Locale("en", "US");
                    resourceManager.set(locale);
                    break;
                }
            }
            printer(resourceManager,locale);
        }
        sc.close();
    }

    private static void printer(ResourceManager resourceManager, Locale locale) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        System.out.println(df.format(new Date()));
        System.out.println(resourceManager.get(Messages.WELCOME));
        System.out.println(resourceManager.get(Messages.QUESTION));
        System.out.println(resourceManager.get(User.FIRST_NAME));
        System.out.println(resourceManager.get(User.LAST_NAME));
    }
}
