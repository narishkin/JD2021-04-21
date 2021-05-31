package by.it.krukouski.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Integer> listA = new ListA<>();
        List<Integer> listB=new ListB<>();
        List<Integer> list2 = new ArrayList<>();

        listB.add(1); list2.add(1);
        listB.add(2); list2.add(2);
        listB.add(3); list2.add(3);
        listB.add(4); list2.add(4);
        System.out.println(listB);
        System.out.println(list2);

        //listB.add(2,8); list2.add(2,8);
        listB.set(0,0); list2.set(0,0);
        //listB.addAll(list2);
        System.out.println(listB);
        System.out.println(list2);




    }
}
