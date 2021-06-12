package by.it.sapazhkou.jd01_12;

import java.util.*;

public class TaskA2 {

    public static void main(String[] args) {

        Integer[] arrayAlpha = {4,55,66,2,3,5,9,6,7,9,232,456,789,75,3,2,1,};
        Integer[] arrayBetta = {4,5,6,2,3,5,4,66,8,76,54,3,33,456,87,7};
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(arrayAlpha));
        Set<Integer> treeSet = new TreeSet<>(Arrays.asList(arrayBetta));
        System.out.println(hashSet.toString());
        System.out.println(treeSet.toString());
        Set<Integer> union = getUnion(hashSet,treeSet);
        Set<Integer> cross =getCross(hashSet,treeSet);
        System.out.println(union.toString());
        System.out.println(cross.toString());

    }

    private static Set<Integer> getUnion(Set<Integer> alpha, Set<Integer> betta){

        HashSet<Integer> returnSet = new HashSet<>(alpha);
        returnSet.addAll(betta);
        return returnSet;
    }

    private static Set<Integer> getCross(Set<Integer> alpha, Set<Integer> betta){

        HashSet<Integer> returnSet = new HashSet<>(alpha);
        returnSet.retainAll(betta);
        return returnSet;
    }



}
