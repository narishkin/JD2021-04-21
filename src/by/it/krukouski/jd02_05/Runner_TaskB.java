package by.it.krukouski.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner_TaskB {

    public static void main(String[] args) {
        ResMan manager = ResMan.INSTANCE;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose language: be en ru");
        String language = scanner.nextLine().trim();
        switch (language){
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
        Locale locale = manager.getResourceBundle();
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        System.out.println(dateFormat.format(date));
        System.out.println(manager.get(Message.message));
        System.out.println(manager.get(User.firstName));
        System.out.println(manager.get(User.lastName));
        System.out.println(manager.get(Message.question));


    }
}
