package by.it.zhurauleu.jd01_12;

import java.util.*;

public class TaskB2 {

    static String process(LinkedList<String> peoples) {
        do {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (!iterator.hasNext()) {
                    if (peoples.size()>1) peoples.removeFirst();
                    break;
                }
                iterator.next();
                iterator.remove();
            }
        } while (peoples.size() > 1);
        return peoples.get(0);
    }

    static String process(ArrayList<String> peoples) {
        do {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (!iterator.hasNext()) {
                    if (peoples.size()>1) peoples.remove(0);
                    break;
                }
                iterator.next();
                iterator.remove();
            }
        } while (peoples.size() > 1);
        return peoples.get(0);
    }

//    static String process(ArrayList<String> peoples) {
//        boolean hasLastRemove = true;
//        do {
//            Iterator<String> iterator = peoples.iterator();
//            if (!hasLastRemove) {
//                iterator.next();
//                iterator.remove();
//                hasLastRemove=true;
//            }
//            while (iterator.hasNext()) {
//                iterator.next();
//                if (!iterator.hasNext()) {
//                    hasLastRemove = false;
//                    break;
//                }
//                iterator.next();
//                iterator.remove();
//            }
//        } while (peoples.size() > 1);
//        return peoples.get(0);
//    }

    public static void main(String[] args) {
        String[] testArray = {"n1", "n2", "n3", "n4", "n5", "n6", "n7", "n8", "n9"};
        List<String> base = Arrays.asList(testArray);
        ArrayList<String> arrayList = new ArrayList<>(base);
        LinkedList<String> linkedList = new LinkedList<>(base);
        String resultarr = process(arrayList);
        System.out.println(resultarr);

        String resultlink = process(linkedList);
        System.out.println(resultlink);

    }



}
