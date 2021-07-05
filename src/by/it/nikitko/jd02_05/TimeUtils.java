package by.it.nikitko.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtils {


    public  String getDate(Locale locale) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        Date date = new Date();
        return (dateFormat.format(date.getTime()));
    }
}
