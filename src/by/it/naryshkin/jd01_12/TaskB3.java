package by.it.naryshkin.jd01_12;

import java.util.*;

public class TaskB3 {



    
    

    static String process(ArrayList<String> peoples) {
        Iterator<String> it = peoples.iterator();
        int counter = 1;
        while (peoples.size() > 1) {
            while (it.hasNext()) {
                it.next();
                if (counter == 2) {
                    it.remove();
                    counter = 1;
                    continue;
                }
                counter++;
            }
            it = peoples.listIterator(0);
        }
        for (String people : peoples) {
            return people;
        }
        return null;
    }

    static String process(LinkedList<String> peoples) {
        Iterator<String> it = peoples.iterator();
        int counter = 1;
        while (peoples.size() > 1) {
            while (it.hasNext()) {
                it.next();
                if (counter == 2) {
                    it.remove();
                    counter = 1;
                    continue;
                }
                counter++;
            }
            it = peoples.listIterator(0);
        }
        for (String people : peoples) {
            return people;
        }
        return null;
    }


    public static void main(String[] args) {
        ArrayList<String> peopleAL = new ArrayList<>();
        for (int i = 0; i < 4096; i++) {
            peopleAL.add(String.valueOf(i));
        }
        LinkedList<String> peopleLL = new LinkedList<>(peopleAL);
//        System.out.println(peopleAL);
//        System.out.println(peopleLL);
        long t1 = System.nanoTime();
        System.out.println(process(peopleAL) + "\n Затраченное время в милисекундах ArrayList: " + (System.nanoTime()-t1)/1000);
        long t2 = System.nanoTime();
        System.out.println(process(peopleLL) + "\n Затраченное время в милисекундах LinkedList: " + (System.nanoTime()-t2)/1000);
    }

}
