package by.it.nikitko.jd02_05;


import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    private ResourceBundle resourceBundle;

    ResourceManager() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(PathCreator.getPath(ResourceManager.class), locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }

}
