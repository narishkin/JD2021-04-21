package by.it.zhurauleu.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;

public class Runner {
    public static void main(String[] args) {
        SetC<Integer> testSet = new SetC<>();
        for (int i = 0; i < 10; i++) {
            testSet.add(i);
        }
        System.out.println(testSet);
        testSet.remove(3);
        System.out.println(testSet);
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(11);
        numbers.add(15);
        numbers.add(23);
        numbers.add(1);
        System.out.println(numbers);
        testSet.addAll(numbers);
        System.out.println(testSet);
        System.out.println(testSet.size());
        HashSet<Object> testHashSet = new HashSet<>();
        testHashSet.add(null);
        testHashSet.add(2);
        testHashSet.add(0);
        testHashSet.add(1);
        testHashSet.clear();
        System.out.println("hashset");
        System.out.println(testHashSet);
//        testHashSet.toString();
    }
}
