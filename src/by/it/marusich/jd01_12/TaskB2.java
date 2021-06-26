package by.it.marusich.jd01_12;

import java.util.*;

public class TaskB2 {

    private static final String[] PEOPLES_ARRAY = new String[]{"1", "1", "2", "3", "4", "5", "6", "7", "8"};
    static List<String> peoples = Arrays.asList(PEOPLES_ARRAY);

    public static void main(String[] args) {
        ArrayList<String> peoplesA = new ArrayList<>(peoples);
        LinkedList<String> peoplesL = new LinkedList<>(peoples);
        System.out.println("peoplesA= " + peoplesA);
        System.out.println("peoplesL= " + peoplesL);
        System.out.println(process(peoplesA));
        System.out.println(process(peoplesL));
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
                iterator=peoples.iterator();
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        int index = 0;
        ListIterator<String> listIterator = peoples.listIterator();
        while (peoples.size()>1){
            if (listIterator.hasNext()){
                listIterator.next();
                index++;
                if (index==2){
                    listIterator.remove();
                    index=0;
                }
            } else {
                listIterator=peoples.listIterator(0);
            }
        }
        return peoples.get(0);
    }
}
