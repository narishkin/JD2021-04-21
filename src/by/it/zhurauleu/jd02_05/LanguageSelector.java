package by.it.zhurauleu.jd02_05;

import java.util.Locale;
import java.util.Scanner;


public class LanguageSelector {
    static final String RUSSIAN = "ru";
    static final String ENGLISH = "en";
    static final String BELARUSIAN = "be";

    public static void select(ResourceManager manager) {
        Scanner input = new Scanner(System.in);
        System.out.println(manager.get(Messages.INPUT_OFFER));
        String language = input.next();
        if (language.equals(RUSSIAN) | language.equals(BELARUSIAN) | language.equals(ENGLISH)) {
            Locale locale = new Locale(language);
            manager.set(locale);
        } else {
            System.out.println(manager.get(Messages.WRONG_INPUT));
        }
    }
}
