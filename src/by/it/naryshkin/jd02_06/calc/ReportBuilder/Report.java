package by.it.naryshkin.jd02_06.calc.ReportBuilder;

import java.util.Date;

public class Report {

    protected String reportHeader;
    protected Date applicationStartTime;
    protected Date applicationEndTime;
    protected StringBuilder operations;
    protected StringBuilder errors;


    public String getReportHeader() {
        return reportHeader;
    }

    public Date getApplicationStartTime() {
        return applicationStartTime;
    }

    public Date getApplicationEndTime() {
        return applicationEndTime;
    }

    public StringBuilder getOperations() {
        return operations;
    }

    public StringBuilder getErrors() {
        return errors;
    }

}
