package by.it._classwork_.calc;

import java.util.HashMap;
import java.util.Map;

public class VarRepo {

    private static Map<String, Var> vars = new HashMap<>();

    private VarRepo() {
    }

    static void save(String name, Var value) {
        vars.put(name, value);
    }

    static boolean contain(String name) {
        return vars.containsKey(name);
    }

    static Var load(String name) {
        Var returnValue = vars.get(name);
        return returnValue;
    }


}
