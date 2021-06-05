package by.it.nikitko.jd01_12;



import java.util.*;

public class TaskB3 {


    public static void main(String[] args) {
        String[] names = new String[4096];
        Random randomGrades = new Random();
        for (int i = 0; i < names.length; i++) {
            names[i] ="n"+Integer.toString(randomGrades.nextInt(100) );
        }

        ArrayList<String> arrayListNames = new ArrayList<>(Arrays.asList(names));
        LinkedList<String> linkedListNames = new LinkedList<>(Arrays.asList(names));
        System.out.println(arrayListNames);

        long lStartTime = System.nanoTime();
        System.out.println(process(arrayListNames));
        long lEndTime = System.nanoTime();
        long arrayListTime = lEndTime - lStartTime;

        lStartTime = System.nanoTime();
        System.out.println(process(linkedListNames));
        lEndTime = System.nanoTime();
        long linkedListTime = lEndTime - lStartTime;


        System.out.println("Elapsed time in mks arrayList: " + arrayListTime / 1000);
        System.out.println("Elapsed time in mks linkedList: " + linkedListTime / 1000);
    }

    static String process(ArrayList<String> peoples) {
        int counter = 0;
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() > 1) {
            if (iterator.hasNext()) {
                counter++;
                iterator.next();
                if (counter == 2) {
                    iterator.remove();
                    counter = 0;
                }
            } else {
                iterator = peoples.iterator();
            }
        }
        String lastName = peoples.get(0);
        return lastName;
    }

    static String process(LinkedList<String> peoples) {
        int counter = 0;
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() > 1) {
            if (iterator.hasNext()) {
                counter++;
                iterator.next();
                if (counter == 2) {
                    iterator.remove();
                    counter = 0;
                }
            } else {
                iterator = peoples.iterator();
            }
        }
        String lastName = peoples.get(0);
        return lastName;
    }

}

