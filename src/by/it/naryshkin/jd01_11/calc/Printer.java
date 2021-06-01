package by.it.naryshkin.jd01_11.calc;

import java.util.*;

public class Printer {
    void print(Var var){
        if (var!=null){
            System.out.println(var);
        }
//        Var.getVar();
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
        Iterator<Map.Entry<String,Var>> it = entrySet.iterator();
        while (it.hasNext()){
            Map.Entry<String,Var> pair = it.next();
            System.out.println(pair.getKey() + "=" + pair.getValue());
        }
    }
}
