package by.it.naryshkin.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        List<String> myListA = new ListA<>();
        List<String> JDKList = new ArrayList<>();


        myListA.add("zero"); JDKList.add("zero");
        myListA.add("first"); JDKList.add("first");
        myListA.add("second"); JDKList.add("second");
        System.out.println("myListA: " + myListA + "\nJDKList: " + JDKList);

        List<String> myListB = new ListB<>();
        myListB.add("third");
        myListB.add("fourth");
        myListB.add("fifth");
        myListB.set(1,"setted");
        JDKList.set(1,"setted");
        System.out.println("myListB: " + myListB + "\nJDKList: " + JDKList.toString());

        JDKList.addAll(Arrays.asList(new String[]{"hh", "hh"}));
        myListB.addAll(Arrays.asList(new String[]{"hh", "hh"}));

        Set<String> JDKHashSet = new HashSet<>();
        Set<Short> MyHashSet = new HashSet<>();

        JDKHashSet.add("one");
        JDKHashSet.add("two");
        JDKHashSet.add("three");
        JDKHashSet.add("four");
        JDKHashSet.add("five");
        MyHashSet.add((short) (1*2));
        MyHashSet.add((short) (2*2));
        MyHashSet.add((short) (3*2));
        MyHashSet.add((short) (4*2));
        MyHashSet.add((short) (5*2));
//        JDKHashSet.addAll();
//        MyHashSet.addAll();

        System.out.println("myHashSet: " + MyHashSet + "\nJDKHashSet: " + JDKHashSet);



    }


}
