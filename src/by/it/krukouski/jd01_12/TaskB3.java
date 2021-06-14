package by.it.krukouski.jd01_12;

import java.util.*;

public class TaskB3 {

    private static final String[] PEOPLES_ARRAY = new String[4096];
    static List<String> peoples = Arrays.asList(PEOPLES_ARRAY);

    public static void main(String[] args) {

        ArrayList<String> peoplesA = new ArrayList<>(peoples);
        LinkedList<String> peoplesL = new LinkedList<>(peoples);
        System.out.println("peoplesA= " + peoplesA);
        System.out.println("peoplesL= " + peoplesL);
        long startTimeArrayList = System.nanoTime();
        process(peoplesA);
        long endTimeArrayList = System.nanoTime();
        long timeArrayList = endTimeArrayList - startTimeArrayList;
        System.out.println("timeArrayList= " + timeArrayList);
        long startTimeLinked = System.nanoTime();
        process(peoplesL);
        long endTimeLinked = System.nanoTime();
        long timeLinked = endTimeLinked - startTimeLinked;
        System.out.println("timeLinkedList= " + timeLinked);
    }

    static String process(ArrayList<String> peoples) {
        int index = 0;
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() > 1) {
            if (iterator.hasNext()) {
                iterator.next();
                index++;
                if (index == 2) {
                    iterator.remove();
                    index = 0;
                }
            } else {
                iterator = peoples.iterator();
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        while (peoples.size() > 1) {
            peoples.addLast(peoples.removeFirst());
            peoples.removeFirst();
        }
        return peoples.get(0);
    }
}


