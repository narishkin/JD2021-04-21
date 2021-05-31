package by.it.nikitko.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List <String> myListA = new ListA<>();
        List <String> myListB = new ListB<>();
        List <String> sampleList = new ArrayList();

        myListA.add("One");
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
        myListB.set(2,"Six");
        sampleList.set(2,"Six");
        System.out.println(myListB);
        System.out.println(sampleList);

        System.out.println("add()");
        myListB.add(2,"Seven");
        sampleList.add(2,"Seven");

        System.out.println(myListB);
        System.out.println(sampleList);

        System.out.println("addAll");
        myListB.addAll(myListB);
        sampleList.addAll(sampleList);

        System.out.println(myListB);
        System.out.println(sampleList);


    }
}
