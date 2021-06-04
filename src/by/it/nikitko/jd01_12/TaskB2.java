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
        Iterator<String> iteratorPeoples = peoples.iterator();
        while (/*iteratorPeoples.hasNext() & */peoples.size() > 1) {
            counter++;
            iteratorPeoples.next();
            if (counter % 2 == 0) {
                iteratorPeoples.remove();
            }
        }
        String lastName = peoples.get(0);
        return lastName;
    }

    static String process(LinkedList<String> peoples) {
        int counter = 0;
        Iterator<String> iteratorPeoples = peoples.iterator();
        while (iteratorPeoples.hasNext() & peoples.size() > 1) {
            iteratorPeoples.next();
            if (counter % 2 == 0) {
                iteratorPeoples.remove();
            }
            counter++;
        }
        String lastName = peoples.get(0);
        return lastName;
    }

}

