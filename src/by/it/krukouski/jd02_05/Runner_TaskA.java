package by.it.krukouski.jd02_05;

import java.util.Locale;

public class Runner_TaskA {
    public static void main(String[] args) {
        ResMan manager = ResMan.INSTANCE;
        if (args.length==2){
            Locale locale = new Locale(args[0], args[1]);
            manager.set(locale);
        }

        System.out.println(manager.get(Message.message));
        System.out.println(manager.get(User.firstName));
        System.out.println(manager.get(User.lastName));
        System.out.println(manager.get(Message.question));

    }
}
