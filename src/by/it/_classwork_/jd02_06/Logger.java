package by.it._classwork_.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {

    private static final String LOG_TXT = "log.txt";
    private static volatile Logger logger;

    private Logger() {
    }

    static Logger getLogger() {
        Logger local = logger;
        if (local == null) {
            synchronized (LOG_TXT) {
                local = logger;
                if (local == null) {
                    local = logger = new Logger();
                }
            }
        }
        return local;
    }


    void log(String message) {
        String fileName = PathCreator.getFileName(Logger.class, LOG_TXT);
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(fileName, true))) {
            printWriter.println(message);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
