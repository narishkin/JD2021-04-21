package by.it.naryshkin.calc;

import java.util.*;

public class Printer {

    void print(Var var){
        if (var!=null){
            System.out.println(var);
        }
    }

    void printMap(Map<String,Var> vars){
        Set<Map.Entry<String,Var>> entrySet = vars.entrySet();
        Iterator<Map.Entry<String,Var>> it = entrySet.iterator();
        while (it.hasNext()){
            Map.Entry<String,Var> pair = it.next();
            System.out.println(pair.getKey() + "=" + pair.getValue());
        }
    }

    void sortedPrintMap(Map<String,Var> vars){
        Map<String,Var> sortedMap = new TreeMap<>(vars);
        Set<Map.Entry<String,Var>> entrySet = sortedMap.entrySet();
        for (Map.Entry<String, Var> pair : entrySet) {
            System.out.println(pair.getKey() + "=" + pair.getValue());
        }
    }
}
