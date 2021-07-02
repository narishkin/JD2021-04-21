package by.it.nikitko.jd02_05;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResourceManager manager = ResourceManager.INSTANCE;
        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            manager.setLocale(locale);
        }
        System.out.println(manager.get(Messages.WELCOME));
        System.out.println(manager.get(Messages.QUESTION));
        System.out.println(manager.get(User.FIRST_NAME));
        System.out.println(manager.get(User.LAST_NAME));

    }
}