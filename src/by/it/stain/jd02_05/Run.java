package by.it.stain.jd02_05;

import java.util.Locale;

public class Run {
    public static void main(String[] args) {
        ResMan manager = ResMan.INSTANCE;
        if(args.length == 2){
            Locale  locale = new Locale(args[0],args[1]);
            manager.set(locale);
        }
        System.out.println(manager.get(Messages.WELCOME));
        System.out.println(manager.get(Messages.QUESTION));
        System.out.println(manager.get(User.FIRST_NAME));
        System.out.println(manager.get(User.LAST_NAME));

    }
}
