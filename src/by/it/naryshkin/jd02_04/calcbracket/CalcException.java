package by.it.naryshkin.jd02_04.calcbracket;

public class CalcException extends Exception{
    private static final long serialVersionUID = -5047047319553344779L;

    public CalcException() {
    }

    public  CalcException(String message) {
        super("ERROR: " + message);
        System.out.println(this.getMessage());
        Printer printer = new Printer();
        printer.print(this);

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
