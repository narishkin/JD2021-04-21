package by.it.karpovich.jd01_11;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {

        //TaskA
        System.out.println("TaskA tests:");
        List<String> list = new ListA<>();
        list.add("Bird");
        list.add("Elephant");
        list.add("Cat");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println(list.size());
        System.out.println(list);
        list.add(1, "Animals");
        System.out.println(list);


//TaskB
        System.out.println("TaskB tests:");
        List<String> listB1 = new ListB<>();
        listB1.add("Opel");
        listB1.add("Audi");
        listB1.add("Reno");
        System.out.println(listB1);
        System.out.println(listB1.set(0,"BMW"));
        System.out.println(listB1);
        System.out.println(listB1);
        listB1.add(1,"Name");
        System.out.println(listB1);

//TaskC

    }
}
