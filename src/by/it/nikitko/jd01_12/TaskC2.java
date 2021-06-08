package by.it.nikitko.jd01_12;

import java.util.*;

public class TaskC2 {

    Set<Integer> intHashSet = new HashSet<>(Arrays.asList(2, 2, 6, 9, 5, 6, 8, 6, -6, 4, 55, 66, 3, 2));
    Set<Double> doubleHashSet = new HashSet<>(Arrays.asList(8.0, 6.0, -4.2, 3.3, 55.0, 46.0, -45.0, 5.0, 56.0, 4.0, 3.5, 3.0, 4.0, 5.0));
    Set<Long> longHashSet = new HashSet<>(Arrays.asList(8L, 6L, 7L, 3L, 4L, 500L));

    public static void main(String[] args) {
        TaskC2 taskC2 = new TaskC2();
        System.out.println("intHashSet     " + taskC2.intHashSet);
        System.out.println("doubleHashSet  " + taskC2.doubleHashSet);
        System.out.println("longHashSet    " + taskC2.longHashSet);
        System.out.println("getUnion       " + getUnion(taskC2.intHashSet, taskC2.doubleHashSet, taskC2.longHashSet));
        System.out.println("getCross       " + getCross(taskC2.intHashSet, taskC2.doubleHashSet, taskC2.longHashSet));
    }

    static HashSet<Double> getUnion(Set<?>... setsArray) {
        HashSet<Double> unionSet = new HashSet<>();
        for (Object o : setsArray[0].toArray()) {
            unionSet.add(Double.valueOf(o.toString()));
        }
        for (int i = 1; i < setsArray.length; i++) {
            for (Object o : setsArray[i].toArray()) {
                unionSet.add(Double.valueOf(o.toString()));
            }
        }
        return unionSet;
    }

    static HashSet<Double> getCross(Set<?>... setsArray) {

        HashSet <Double> crossSet = new HashSet<>();
        for (Object o : setsArray[0].toArray()) {
            crossSet.add(Double.valueOf(o.toString()));
        }
        for (int i = 1; i < setsArray.length; i++) {
            HashSet <Double> currentSet = new HashSet<>();
            for (Object o : setsArray[i].toArray()) {
                currentSet.add(Double.valueOf(o.toString()));
            }
            crossSet.retainAll(currentSet);
        }
        return crossSet;
    }
}
