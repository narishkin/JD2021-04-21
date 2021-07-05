package by.it.nikitko.calc;



import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    private final String RES_LANGUAGE = "by.it.nikitko.calc.res.language";
    private ResourceBundle resourceBundle;

    ResourceManager() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(RES_LANGUAGE, locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }

}
