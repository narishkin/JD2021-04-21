package by.it.nikitko.jd02_05;

import java.text.DateFormat;
import java.util.Date;

public class TimeUtils {

    ResourceManager manager = ResourceManager.INSTANCE;
    private DateFormat dateFormat= manager.getDateFormat();

    public  String getDate() {
        Date date = new Date();
       String dateString =(dateFormat.format(date.getTime()));
       return dateString;
    }
}
