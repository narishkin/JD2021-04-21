package by.it.marusich.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] a = {1, 5, 9, 7, 5, 3, 2, 4, 9};
        Integer[] b = {6, 9, 6, 3, 2, 5, 7, 9, 6};
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(a));
        Set<Integer> treeSet = new TreeSet<>(Arrays.asList(b));
        System.out.println("hashSet " + hashSet);
        System.out.println("treeSet " + treeSet);
        System.out.println("getCross= " + getCross(hashSet, treeSet));
        System.out.println("getUnion= " + getUnion(hashSet, treeSet));

    }

    private static Set<Integer> getUnion(Set<Integer> hashSet, Set<Integer> treeSet) {
        Set<Integer> resultSet = new HashSet<>(hashSet);
        resultSet.addAll(treeSet);
        return resultSet;
    }

    private static Set<Integer> getCross(Set<Integer> hashSet, Set<Integer> treeSet) {
        Set<Integer> resultSet = new HashSet<>(hashSet);
        resultSet.retainAll(treeSet);
        return resultSet;
    }


}
