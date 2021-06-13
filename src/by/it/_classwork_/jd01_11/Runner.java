package by.it._classwork_.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> values = new ArrayList<>();
        values.add("One");
        values.add("Two");
        values.add("Three");
        values.add("Four");
        System.out.println(values);
        values.remove(2);
        System.out.println(values);
        values = new ListA<>();
        values.add("One");
        values.add("Two");
        values.add("Three");
        values.add("Four");
        System.out.println(values);
        values.remove(2);
        System.out.println(values);

    }
}
