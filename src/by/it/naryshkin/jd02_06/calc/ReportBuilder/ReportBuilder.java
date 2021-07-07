package by.it.naryshkin.jd02_06.calc.ReportBuilder;

import java.util.Calendar;

public class ReportBuilder {

    private final Report report;
    StringBuilder stringBuilder = new StringBuilder();

    public ReportBuilder() {
        report = new Report();
    }

    public ReportBuilder header(String header) {
        report.reportHeader = header;
        return this;
    }

    public ReportBuilder appStartTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        report.applicationStartTime = calendar.getTime();
        return this;
    }

    public ReportBuilder appEndTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        report.applicationEndTime = calendar.getTime();
        return this;
    }

    public ReportBuilder operations(String s) {
        report.operations = stringBuilder.append(getCurrentTime()).append(" ").append(s).append("\n");
        return this;
    }

    public ReportBuilder errors(String s) {
        report.errors = stringBuilder.append(getCurrentTime()).append(" ").append(s).append("\n");
        return this;
    }

    public void reportWriter(String fileName) {
        ReportWriter reportWriter = ReportWriter.getInstance();
        reportWriter.setReportFile(fileName);
        if (report.getReportHeader() != null) reportWriter.reportCreator(report.getReportHeader());
        if (report.getApplicationStartTime() != null)
            reportWriter.reportCreator("Session started on: " + report.getApplicationStartTime().toString());
        if (report.getOperations() != null) reportWriter.reportCreator(report.getOperations().toString());
        if (report.getErrors() != null) reportWriter.reportCreator(report.getErrors().toString());
        if (report.getApplicationEndTime() != null)
            reportWriter.reportCreator("Session finished on: " + report.getApplicationEndTime().toString());

    }

    public Report build() {
        return report;
    }

    private String getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime().toString();
    }


}
