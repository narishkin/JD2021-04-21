package by.it.krukouski.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private final String RES_LANGUAGE = "";

   private ResourceBundle resourceBundle;

   ResMan(){
       set(Locale.getDefault());
   }

   public void set(Locale locale){
       resourceBundle= ResourceBundle.getBundle(RES_LANGUAGE,locale);
   }

   public String get(String key){
       return resourceBundle.getString(key);
   }
}
