package by.it.naryshkin.calc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
    private static final String VARS_TXT = "vars.txt";
    private static final String FILE_NAME = PathCreator.getFileName(ConsoleRunner.class, VARS_TXT);
    private static Map<String, Var> vars = new HashMap<>();

    static Var setVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    public static Map<String, Var> getVar() {
        return vars;
    }

    public static void saveVars(){
        try(PrintWriter printWriter = new PrintWriter(FILE_NAME)){
            for(Map.Entry<String, Var> varsPair : vars.entrySet()) {
                printWriter.printf("%s=%s\n", varsPair.getKey(),varsPair.getValue());
            }
        } catch (FileNotFoundException e) {
            throw  new RuntimeException(e);
        }
    }

    public static void loadVars(){
        Path path = Paths.get(FILE_NAME);
        if (Files.exists(path)){
            try {
                Parser parser = new Parser();
                Files.lines(path).forEach(s -> eval(parser,s));
            } catch (IOException e) {
                throw  new RuntimeException(e);
            }
        }
    }

    private static void eval(Parser parser,String s){
        try{
            parser.calc(s);
        } catch (CalcException e){
            e.printStackTrace();
        }
    }


    static Var createVar(String operand) throws CalcException{
        operand = operand.trim();
        operand = operand.replaceAll("\\s+", "");
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        } else
        if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        } else
        if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand);
        } else
        if (operand.matches(Patterns.VARNAME)) {
            return vars.get(operand);
        } else {
            throw new CalcException("Unable to parse expression " + operand);
        }
    }

    @Override
    public Var add(Var other) throws CalcException{
        throw new CalcException("Операция сложения " + this + "+" + other + " невозможна");

    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException("Операция вычитания " + this + "-" + other + " невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException("Операция умножения " + this + "*" + other + " невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException("Операция деления " + this + "/" + other + " невозможна");
    }
}
