package by.it.nikitko.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List <String> myList = new ListA<>();
        List <String> sampleList = new ArrayList();


        myList.add("One");
        sampleList.add("One");
        myList.add("Two");
        sampleList.add("Two");
        myList.add("Three");
        sampleList.add("Three");
        myList.add("Four");
        sampleList.add("Four");

        System.out.println(myList);
        System.out.println(sampleList);

        myList.remove(2);
        sampleList.remove(2);

        System.out.println(myList);
        System.out.println(sampleList);

        System.out.println(myList.get(1));
        System.out.println(sampleList.get(1));

    }
}
