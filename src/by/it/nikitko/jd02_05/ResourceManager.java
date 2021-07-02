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
    private DateFormat dateFormat;
    private DateTimeFormatter dateTimeFormatter;

    ResourceManager() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(PathCreator.getPath(ResourceManager.class), locale);
     // dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
         dateTimeFormatter = new DateTimeFormatter(locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }

    public  void getDate() {


     //   String s = dateFormat.format(new Date());
       LocalDate today = LocalDate.now();


        // String todayString = today.toString();
       //    String s = dateFormat.format(todayString);
        try {
           Date d=null;
                  d=  dateFormat.parse("April 12, 2016");
            System.out.println(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
