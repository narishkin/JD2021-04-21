package by.it.nakov.jd02_04;

public class CalcException extends Exception{
    public CalcException(){}
    public CalcException(String message){super("Error: "+message);}
    public CalcException(String message,Throwable course){super("Error: "+message,course);}
    public CalcException(Throwable course){super("Error: "+ course);}

}
