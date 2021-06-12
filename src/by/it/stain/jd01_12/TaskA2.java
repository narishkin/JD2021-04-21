package by.it.stain.jd01_12;

import java.util.*;

public class TaskA2 {
    private static Set<Integer>getUnion(Set<Integer>one, Set<Integer> two){
        Set<Integer>result= new HashSet<>(one);
        Iterator<Integer>iterator= two.iterator();
        while (iterator.hasNext())
            result.add(iterator.next());
    return result;
    }
    private static Set<Integer>getCross(Set<Integer>one, Set<Integer> two){
        Set<Integer>result= new HashSet<>(one);
        result.retainAll(two);
        return result;
    }

    public static void main(String[] args) {
        TreeSet<Integer>treeSet=new TreeSet<>(Arrays.asList(1,2,3,4,4,5,5,6,6,7,7,8,8));
        HashSet<Integer>hashSet=new HashSet<>(Arrays.asList(6,4,8,4,3,7,5,6,4,4,3,5,9));
        System.out.println(getUnion(treeSet,hashSet));
        System.out.println(getCross(treeSet,hashSet));

    }
}
