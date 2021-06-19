package by.it.naryshkin.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Printer {

    public static final String CONSOLE_LOG = "log.txt";
    FileWriter fileWriter = null;

    void print(Var var) {
        if (var != null) {
            System.out.println(var);
        }
    }

    void print(CalcException e) {
        System.out.println(e.getMessage());
        try {
            fileWriter = new FileWriter(PathCreator.getFileName(ConsoleRunner.class, Printer.CONSOLE_LOG),true);
            fileWriter.write(String.valueOf(e) + "\n");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) fileWriter.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    void printMap(Map<String, Var> vars) {
        Set<Map.Entry<String, Var>> entrySet = vars.entrySet();
        Iterator<Map.Entry<String, Var>> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry<String, Var> pair = it.next();
            System.out.println(pair.getKey() + "=" + pair.getValue());
        }
    }

    void sortedPrintMap(Map<String, Var> vars) {
        Map<String, Var> sortedMap = new TreeMap<>(vars);
        Set<Map.Entry<String, Var>> entrySet = sortedMap.entrySet();
        for (Map.Entry<String, Var> pair : entrySet) {
            System.out.println(pair.getKey() + "=" + pair.getValue());
        }
    }
}
