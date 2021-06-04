package by.it.nikitko.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskC2 {
    Integer[] arrayA = {2, -8, 6, 9, 47, 6, 8, 6, -6, 4, 55, 66, 3, 2};
    Integer[] arrayB = {8, 6, -4, 3, 55, 46, -45, 55, 56, 4, 3, 3, 4, 5};

    Set<Integer> hashSet = new HashSet<>(Arrays.asList(arrayA));
    Set<Integer> treeSet = new TreeSet<>(Arrays.asList(arrayB));

    public static void main(String[] args) {
        TaskC2 taskC2 = new TaskC2();
        System.out.println("hashSet  " + taskC2.hashSet);
        System.out.println("treeSet  " + taskC2.treeSet);
        System.out.println("getUnion " + getUnion(taskC2.hashSet, taskC2.treeSet));
        System.out.println("getCross " + getCross(taskC2.hashSet, taskC2.treeSet));
    }

    static Set<Integer> getUnion(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>(first);
        result.addAll(second);
        return result;
    }

    static Set<Integer> getCross(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>(first);
        result.retainAll(second);
        return result;
    }

}
