package by.it.sapazhkou.jd01_12;

import java.util.*;

public class TaskB2 {

    //    ArrayList<String> peoples1 = new ArrayList<>(Arrays.asList("Serge", "Mark", "Petr", "Ivan", "Nikolay", "Sofi", "Elena", "Olga", "Tatyana", "Elis", "Alesya"));
    ArrayList<String> peoples1 = new ArrayList<>(Arrays.asList("Serge", "Mark", "Petr"));

//    LinkedList<String> peoples2 = new LinkedList<>(Arrays.asList("Serge", "Mark", "Petr", "Ivan", "Nikolay", "Sofi", "Elena", "Olga", "Tatyana", "Elis", "Alesya"));

    public static void main(String[] args) {
        TaskB2 task = new TaskB2();
        System.out.println(process(task.peoples1));
//        System.out.println(process(task.peoples2));
    }

    static String process(ArrayList<String> peoples) {
        String result = "";
        int i =0;
        while (peoples.size() > 1) {
            ListIterator<String> it = peoples.listIterator(i);
            if ((i + 1) % 2 == 0) {
                it.next();
                it.remove();
            } else {
                if(it.nextIndex() <= peoples.size()-1) {
                    result = it.next();
                } else {
                    i=-1;
                }
            }
            i++;
        }
        return result;
    }

    static String process(LinkedList<String> peoples) {
        String result = "";
        int i =0;
        while (peoples.size() > 1) {
                ListIterator<String> it = peoples.listIterator(i);
                if ((i + 1) % 2 == 0) {
                    it.next();
                    it.remove();
                } else {
                    result = it.next();
                }
                i++;
            }
        return result;
    }

}
