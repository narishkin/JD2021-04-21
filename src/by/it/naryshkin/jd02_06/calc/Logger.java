package by.it.naryshkin.jd02_06.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;


class Logger {

    private static final String CONSOLE_LOG = "log.txt";
    private static volatile Logger logger;

    private Logger(){
    }

    static Logger getLogger(){
        Logger local = logger;
        if (local == null){
            synchronized (Logger.class){
                local = logger;
                if (local == null){
                    local = logger = new Logger();
                }
            }
        }
        return local;
    }

    void log(String message){
        String fileName = PathCreator.getFileName(Logger.class,CONSOLE_LOG);
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(fileName,true))){
            printWriter.println(getCurrentTime() + "\t" + message);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getCurrentTime(){
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime().toString();
    }
}
