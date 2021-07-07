package by.it.naryshkin.jd02_06.calc;

import by.it.naryshkin.jd02_06.calc.ReportBuilder.Report;
import by.it.naryshkin.jd02_06.calc.ReportBuilder.ReportBuilder;
import by.it.naryshkin.jd02_06.calc.ReportBuilder.ReportWriter;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    static final String KEY_STOP_APP = "end";
    public ResourceManager resourceManager = ResourceManager.INSTANCE;

    public static void main(String[] args) {
        ConsoleRunner consoleRunner = new ConsoleRunner();

        ReportBuilder reportBuilder = new ReportBuilder();
        ReportBuilder errorsReportBuilder = new ReportBuilder();
        reportBuilder.header("Calculator session REPORT").appStartTime().build();
        errorsReportBuilder.header("Calculator session errors REPORT").appStartTime();

        Logger logger = Logger.getLogger();
        EnumLogger enumLogger = EnumLogger.INSTANCE;
        OnDemandHolderIdiomSingleton onDemandHolderIdiomSingleton = OnDemandHolderIdiomSingleton.getInstance();


        Printer printer = new Printer();
        Parser parser = new Parser();
        VarRepo.loadVars();
        Scanner sc = new Scanner(System.in);
        String line;
        for (; ; ) {
            line = sc.nextLine();
            line = consoleRunner.localeSelector(line);
            if (line.isEmpty()) continue;
            if (!line.equals(KEY_STOP_APP)) {
                try {
                    logger.log(line);
                    enumLogger.log(line);
                    onDemandHolderIdiomSingleton.log(line);
                    reportBuilder.operations(line);
                    Var result = parser.calc(line);
                    printer.print(result);
                    if (result != null) {
                        logger.log(result.toString());
                        enumLogger.log(result.toString());
                        onDemandHolderIdiomSingleton.log(result.toString());
                        reportBuilder.operations(result.toString());
                    }
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                    logger.log(e.getMessage());
                    enumLogger.log(e.getMessage());
                    onDemandHolderIdiomSingleton.log(e.getMessage());
                    errorsReportBuilder.errors(e.getMessage());
                }
            } else {
                VarRepo.saveVars();
                reportBuilder.appEndTime().build();
                errorsReportBuilder.appEndTime().build();
                reportBuilder.reportWriter("Report.txt");
                errorsReportBuilder.reportWriter("errorsReport.txt");
                break;
            }
        }
    }

    private String localeSelector(String line) {
        Locale locale;
        switch (line) {
            case "en": {
                locale = new Locale("en", "US");
                resourceManager.set(locale);
                System.out.println("English");
                return "";
            }
            case "be": {
                locale = new Locale("be", "BY");
                resourceManager.set(locale);
                System.out.println("Белорусский");
                return "";

            }
            case "ru": {
                locale = new Locale("ru", "RU");
                resourceManager.set(locale);
                System.out.println("Русский");
                return "";
            }
            default:
                return line;
        }
    }
}
