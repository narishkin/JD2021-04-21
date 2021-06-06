package by.it.naryshkin.jd01_12;

import java.util.*;

public class TaskC2 {
    public static void main(String[] args) {

        Set<Long> a = new HashSet<Long>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        Set<Integer> b = new HashSet<Integer>(Arrays.asList(4, 3, 5, 6, 7, 8));
        Set<Double> c = new HashSet<Double>(Arrays.asList(0., 1., 2., 3., 4., 5.));
        Set<Double> d = new HashSet<Double>(Arrays.asList(2., 3., 4., 9.));
//        System.out.println(getCross( a ,b, c, d));
        System.out.println(getUnion( a ,b, c, d));

    }
    static Set<Number> getCross(Set<?>... sets) {
        Set<Number> result = new HashSet<>();
//        System.out.println(result);

        int c;
        for (int i = 0; i < sets.length; i++) {
            Iterator<?> it = sets[i].iterator();
            while (it.hasNext()) {
                c = 0;
                Number n = (Number) it.next();
                System.out.println(n);
                for (int j = 0; j < sets.length; j++) {
                    Iterator<?> it2 = sets[j].iterator();
                    while (it2.hasNext()){
                    if (it2.next() == (n)) {
                        c++;

                    }
                    }
                }
                if (c == sets.length) {
                    result.add((Number) n);
                }
            }
            System.out.println(result);
        }
        return result;
    }
    static Set<Number> getUnion(Set<?>... sets) {
        Set<Number> result = new HashSet<>();
        for (int i = 0; i < sets.length; i++) {
            result.addAll((Collection<? extends Number>) sets[i]);
        }

        return result;
    }


}
