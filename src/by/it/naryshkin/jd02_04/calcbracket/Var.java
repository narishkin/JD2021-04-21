package by.it.naryshkin.jd02_04.calcbracket;

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
    public static Map<String, Var> vars = new HashMap<>();

    static void setVar(String name, Var var) {
        vars.put(name, var);
    }

    public static Map<String, Var> getVar() {
        return vars;
    }

    public static void saveVars() {
        try (PrintWriter printWriter = new PrintWriter(FILE_NAME)) {
            for (Map.Entry<String, Var> varsPair : vars.entrySet()) {
                printWriter.printf("%s=%s\n", varsPair.getKey(), varsPair.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadVars() {
        Path path = Paths.get(FILE_NAME);
        if (Files.exists(path)) {
            try {
                Parser parser = new Parser();
                Files.lines(path).forEach(s -> eval(parser, s));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void eval(Parser parser, String s) {
        try {
            parser.calc(s);
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения " + this + "+" + other + " невозможна");

    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания " + this + "-" + other + " невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения " + this + "*" + other + " невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления " + this + "/" + other + " невозможна");
    }
}
