package by.it.naryshkin.jd02_06.calc.ReportBuilder;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReportWriter {
    private static  String REPORT_FILE;

    private ReportWriter() {

    }

    public  void setReportFile(String reportFile) {
        REPORT_FILE = reportFile;
    }

    private static class LazyHolder {
        static final ReportWriter INSTANCE = new ReportWriter();
    }

    public static ReportWriter getInstance() {
        return ReportWriter.LazyHolder.INSTANCE;
    }


    public void reportCreator(String message){
        String fileName = PathCreator.getFileName(ReportWriter.class,REPORT_FILE);
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(fileName,true))){
            printWriter.println(message);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
