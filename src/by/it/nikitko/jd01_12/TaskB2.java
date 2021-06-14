package by.it.nikitko.jd01_12;

import java.util.*;

public class TaskB2 {


    public static void main(String[] args) {
        String[] names = {"a", "b", "c", "d", "f"};
        ArrayList<String> arrayListNames = new ArrayList<>(Arrays.asList(names));
        LinkedList<String> linkedListNames = new LinkedList<>(Arrays.asList(names));
        System.out.println(process(arrayListNames));
        System.out.println(process(linkedListNames));

    }

    static String process(ArrayList<String> peoples) {
        int counter = 0;
        Iterator<String> iterator = peoples.iterator();
        while ( peoples.size() > 1) {
            if (iterator.hasNext()) {
                counter++;
                iterator.next();
                if (counter == 2) {
                    iterator.remove();
                    counter = 0;
                }
            }
            else {
                iterator = peoples.iterator();
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        int counter = 0;
        Iterator<String> iterator = peoples.iterator();
        while ( peoples.size() > 1) {
            if (iterator.hasNext()) {
                counter++;
                iterator.next();
                if (counter == 2) {
                    iterator.remove();
                    counter = 0;
                }
            }
            else {
                iterator = peoples.iterator();
            }
        }
        return peoples.get(0);
    }

}

