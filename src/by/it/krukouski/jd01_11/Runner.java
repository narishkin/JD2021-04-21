package by.it.krukouski.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Integer> list = new ListA<>();
        List<Integer> list2 = new ArrayList<>();

        list.add(1); list2.add(1);
        list.add(2); list2.add(2);
        list.add(3); list2.add(3);
        list.add(4); list2.add(4);
        System.out.println(list);
        System.out.println(list2);

        list.remove(2); list2.remove(2);
        System.out.println(list);
        System.out.println(list2);


    }
}
