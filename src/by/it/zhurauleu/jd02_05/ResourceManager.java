package by.it.zhurauleu.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    private final String RESOURCE_LANGUAGE = "by.it.zhurauleu.jd02_05.resource.language";

    private ResourceBundle resourceBundle;


    ResourceManager() {
        set(Locale.ENGLISH);
    }

    public void set(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(RESOURCE_LANGUAGE, locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }


}
