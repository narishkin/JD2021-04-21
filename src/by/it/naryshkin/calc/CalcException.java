package by.it.naryshkin.calc;

public class CalcException extends Exception{
    private static final long serialVersionUID = -5047047319553344779L;

    public CalcException() {
    }

    public CalcException(String message) {
        super("ERROR: " + message);
        Printer printer = new Printer();
        printer.print(new CalcException());

    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR: " + message, cause, enableSuppression, writableStackTrace);
    }
}
