package by.it.krukouski.jd02_04;

import java.util.HashMap;
import java.util.Map;

public class VarRepo {

    private static Map<String, Var> vars = new HashMap<>();

    public VarRepo() {
    }

    static void save(String name, Var var) {
        vars.put(name, var);
    }

    static boolean contain(String name) {
        return vars.containsKey(name);
    }

    static Var load(String name) {
        return vars.get(name);
    }


}
