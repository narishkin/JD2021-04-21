package by.it.nikitko.jd02_05;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    private ResourceBundle resourceBundle;

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    private DateFormat dateFormat;

    ResourceManager() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(PathCreator.getPath(ResourceManager.class), locale);
        dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }

    public void getDate() {
        Date date = new Date();
        System.out.println(dateFormat.format(date.getTime()));

    }
}
