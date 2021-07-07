package by.it.naryshkin.jd02_06.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

public enum EnumLogger {

    INSTANCE;
    private static final String CONSOLE_LOG = "logViaEnum.txt";

    void log(String message){
        String fileName = PathCreator.getFileName(EnumLogger.class,CONSOLE_LOG);
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(fileName,true))){
            printWriter.println(getCurrentTime() + "\t" + message);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCurrentTime(){
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime().toString();
    }

}
