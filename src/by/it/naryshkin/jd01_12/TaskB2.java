package by.it.naryshkin.jd01_12;

import java.util.*;

public class TaskB2 {

    static ArrayList<String> peopleAL = new ArrayList<>(Arrays.asList("Alfred", "Bob", "George", "Eddie", "Henry"));
    static LinkedList<String> peopleLL = new LinkedList<>(peopleAL);

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
        System.out.println(process(peopleAL));
        System.out.println(process(peopleLL));
    }

}
