package by.it.krukouski.jd01_12;

import java.util.*;

public class TaskB2 {

    private static final String[] PEOPLES_ARRAY = new String[]{"a", "b", "c", "d", "e"};
    static List<String> peoples = Arrays.asList(PEOPLES_ARRAY);

    public static void main(String[] args) {
        ArrayList<String> peoplesA = new ArrayList<>(peoples);
        LinkedList<String> peoplesL = new LinkedList<>(peoples);
        System.out.println("peoplesA= " + peoplesA);
        System.out.println("peoplesL= " + peoplesL);
        System.out.println(process(peoplesA));
        System.out.println(process(peoplesL));
        System.out.println(peoplesA);
    }

    static String process(ArrayList<String> peoples) {
        int index = 0;
        Iterator<String> iterator = peoples.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.equals(peoples.get(index))) {
                iterator.remove();
                index += 1;
                if (index > peoples.size()) {
                    index = 0;
                }
            }
        }
        return peoples.get(index+1);
    }

    static String process(LinkedList<String> peoples) {
        return null;

    }
}

