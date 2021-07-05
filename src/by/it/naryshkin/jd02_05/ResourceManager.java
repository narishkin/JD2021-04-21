package by.it.naryshkin.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    @SuppressWarnings("FieldCanBeLocal")
    private final String RESOURCE_LANGUAGE = "by.it.naryshkin.jd02_05.res.language";

    private ResourceBundle resourceBundle;

    ResourceManager() {
        set(Locale.getDefault());
    }

    public void set(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(RESOURCE_LANGUAGE, locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
}
