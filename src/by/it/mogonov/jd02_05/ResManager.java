package by.it.mogonov.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResManager {
    INSTANCE;


    private ResourceBundle resourceBundle;

    ResManager(){ set(Locale.getDefault());}

    public void set(Locale locale) {
        String RES_LANGUAGE = "by.it.mogonov.jd02_05.res.language_en_US";
        resourceBundle = ResourceBundle.getBundle(RES_LANGUAGE, locale);}

    public String get(String key) {return resourceBundle.getString(key);}

}

