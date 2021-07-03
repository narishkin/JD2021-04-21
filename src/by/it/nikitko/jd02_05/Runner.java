package by.it.nikitko.jd02_05;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        TimeUtils timeUtils = new TimeUtils();
        ResourceManager manager = ResourceManager.INSTANCE;
        Locale locale= new Locale("en", "US") ;
        manager.setLocale(locale);
        if (args.length == 2) {
             locale = new Locale(args[0], args[1]);
            manager.setLocale(locale);
        }
        System.out.println(manager.get(Messages.WELCOME));
        System.out.println(manager.get(Messages.QUESTION));
        System.out.println(manager.get(User.FIRST_NAME));
        System.out.println(manager.get(User.LAST_NAME));
        System.out.println(timeUtils.getDate(locale));

    }
}