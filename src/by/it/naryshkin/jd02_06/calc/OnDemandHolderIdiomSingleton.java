package by.it.naryshkin.jd02_06.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

public class OnDemandHolderIdiomSingleton {
    private static final String CONSOLE_LOG = "logODHIS.txt";

    private OnDemandHolderIdiomSingleton() {

    }

    private static class LazyHolder {
        static final OnDemandHolderIdiomSingleton INSTANCE = new OnDemandHolderIdiomSingleton();
    }

    public static OnDemandHolderIdiomSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    void log(String message) {
        String fileName = PathCreator.getFileName(OnDemandHolderIdiomSingleton.class, CONSOLE_LOG);
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(fileName, true))) {
            printWriter.println(getCurrentTime() + "\t" + message);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime().toString();
    }
}
