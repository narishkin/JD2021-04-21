package by.it.krukouski.jd02_05.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private ResourceBundle resourceBundle;

    @SuppressWarnings("FieldCanBeLocal")
    private final String RES_LANGUAGE="by.it.krukouski.jd02_05.calc.res.language";

    ResMan(){
        set(Locale.getDefault());
    }

    public void set(Locale locale) {
        resourceBundle=ResourceBundle.getBundle(RES_LANGUAGE,locale);
    }

    public String get(String key){
        return resourceBundle.getString(key);
    }


}
