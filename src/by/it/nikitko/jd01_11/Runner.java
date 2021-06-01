package by.it.nikitko.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        List<String> myListA = new ListA<>();
        List<String> myListB = new ListB<>();
        List<String> sampleList = new ArrayList();
        Set<String> myHashSet = new SetC<>();
        Set<String> myHashSet2 = new SetC<>();
        Set<String> sampleHashSet = new HashSet<>();
        Set<String> sampleHashSet2 = new HashSet<>();

        myListA.add(null);
        myListB.add("One");
        sampleList.add("One");
        myListA.add("Two");
        myListB.add("Two");
        sampleList.add("Two");
        myListA.add("Three");
        myListB.add("Three");
        sampleList.add("Three");
        myListA.add("Four");
        myListB.add("Four");
        sampleList.add("Four");


        System.out.println("Add");
        System.out.println(myListA);
        System.out.println(myListB);
        System.out.println(sampleList);

        System.out.println("Remove");
        myListA.remove(2);
        myListB.remove(2);
        sampleList.remove(2);
        System.out.println(myListA);
        System.out.println(myListB);
        System.out.println(sampleList);

        System.out.println("Get");
        System.out.println(myListA.get(1));
        System.out.println(myListB.get(1));
        System.out.println(sampleList.get(1));

        System.out.println("set");
        myListB.set(2, "Six");
        sampleList.set(2, "Six");
        System.out.println(myListB);
        System.out.println(sampleList);

        System.out.println("add()");
        myListB.add(2, "Seven");
        sampleList.add(2, "Seven");

        System.out.println(myListB);
        System.out.println(sampleList);

        System.out.println("addAll");
        myListB.addAll(myListB);
        sampleList.addAll(sampleList);

        System.out.println(myListB);
        System.out.println(sampleList);

        myHashSet.add("10");
        sampleHashSet.add("10");
        myHashSet.add("20");
        myHashSet.add(null);
        sampleHashSet.add("20");
        sampleHashSet.add(null);
        myHashSet.add("30");
        sampleHashSet.add("30");
        myHashSet2.add("5");
        myHashSet2.add("7");
        myHashSet2.add("6");
        myHashSet2.add("9");
        myHashSet2.add("92");
        myHashSet2.add("56");
        myHashSet2.add(null);

        myHashSet2.add("1004");
        myHashSet2.add("1000");
        myHashSet2.add("30");
        sampleHashSet2.add("1004");
        sampleHashSet2.add("1000");
        sampleHashSet2.add("2000");
        sampleHashSet2.add("30");

        System.out.println(myHashSet);
        System.out.println(sampleHashSet);

        myHashSet.remove(10);
        sampleHashSet.remove(10);
        System.out.println(myHashSet);
        System.out.println(sampleHashSet);

        System.out.println("HashSet addAll");
        System.out.println("myHashSet "+myHashSet);
        System.out.println("myHashSet2 "+myHashSet2);
        System.out.println("myHashSet size ="+myHashSet.size());
        System.out.println("myHashSet2 size ="+myHashSet2.size());

        myHashSet.addAll(myHashSet2);
        System.out.println("myHashSet after addAll"+myHashSet);
        System.out.println("myHashSet size ="+myHashSet.size());

        boolean a=myHashSet.contains("301");
        boolean b=myHashSet.containsAll(myHashSet2);
        System.out.println(b);
        //sampleHashSet.addAll(sampleHashSet2);
       // System.out.println(sampleHashSet);
       // System.out.println(myHashSet.size());
        System.out.println("myHashSet size before clear="+myHashSet.size());
        myHashSet.clear();
        System.out.println("myHashSet after clear"+myHashSet);
        System.out.println("myHashSet size after clear="+myHashSet.size());



    }
}
