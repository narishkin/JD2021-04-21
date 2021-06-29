package by.it.naryshkin.jd02_04.calcbracket;

public class Patterns {

    final static String OPERATION = "(?<=[^-+*/=,{])([-+*/=])";
    final static String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    final static String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    final static String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
    final static String VARNAME = "[A-Z]";



}
