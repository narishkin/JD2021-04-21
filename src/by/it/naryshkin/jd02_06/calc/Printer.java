package by.it.naryshkin.jd02_06.calc;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Printer {

    void print(Var var) {
        if (var != null) {
            System.out.println(var);
        }
    }

    void printMap(Map<String, Var> vars) {
        Logger logger = Logger.getLogger();
        EnumLogger enumLogger = EnumLogger.INSTANCE;
        OnDemandHolderIdiomSingleton onDemandHolderIdiomSingleton = OnDemandHolderIdiomSingleton.getInstance();
        Set<Map.Entry<String, Var>> entrySet = vars.entrySet();
        Iterator<Map.Entry<String, Var>> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry<String, Var> pair = it.next();
            System.out.println(pair.getKey() + "=" + pair.getValue());
            logger.log(pair.getKey() + "=" + pair.getValue());
            enumLogger.log(pair.getKey() + "=" + pair.getValue());
            onDemandHolderIdiomSingleton.log(pair.getKey() + "=" + pair.getValue());
        }
    }

    void sortedPrintMap(Map<String, Var> vars) {
        Logger logger = Logger.getLogger();
        EnumLogger enumLogger = EnumLogger.INSTANCE;
        OnDemandHolderIdiomSingleton onDemandHolderIdiomSingleton = OnDemandHolderIdiomSingleton.getInstance();
        Map<String, Var> sortedMap = new TreeMap<>(vars);
        Set<Map.Entry<String, Var>> entrySet = sortedMap.entrySet();
        for (Map.Entry<String, Var> pair : entrySet) {
            System.out.println(pair.getKey() + "=" + pair.getValue());
            logger.log(pair.getKey() + "=" + pair.getValue());
            enumLogger.log(pair.getKey() + "=" + pair.getValue());
            onDemandHolderIdiomSingleton.log(pair.getKey() + "=" + pair.getValue());
        }
    }
}
