package by.it.naryshkin.jd01_12;

import java.util.*;

public class TaskA2 {



    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
        Set<Integer> set2 = new TreeSet<>(Arrays.asList(4,5,6,7,8,9,10));
        System.out.println(getCross(set1,set2));
        System.out.println(getUnion(set1,set2));


    }
    static Set<Integer> getCross(Set<Integer> one, Set<Integer> two){
        Set<Integer> result =new HashSet<>(one);
//       result.retainAll(two);
       Iterator<Integer> it = result.iterator();
       while (it.hasNext()){
           if (!two.contains(it.next())){
               it.remove();
           }
       }
       return result;
    }

    static Set<Integer> getUnion(Set<Integer> one, Set<Integer> two){
        Set<Integer> result = new HashSet<>(one);
        Iterator<Integer> it = two.iterator();
        while (it.hasNext()){
            result.add(it.next());
        }
        return result;
    }
}
