package by.it.zhurauleu.jd02_05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Runner {
    public static void main(String[] args) {

        ResourceManager manager = ResourceManager.INSTANCE;
        if (args.length == 2) {
            manager.set(new Locale(args[0], args[1]));
        }
        LanguageSelector.select(manager);
        consolePrint(manager);
    }

    private static void consolePrint(ResourceManager manager) {
        System.out.println(manager.get(Messages.WELCOME));
        System.out.println(manager.get(Messages.QUESTION));
        System.out.println(manager.get(User.FIRST_NAME));
        System.out.println(manager.get(User.LAST_NAME));
        String dateFormat = manager.get(Formats.DATE_FORMAT);
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern(dateFormat)));
    }

}
