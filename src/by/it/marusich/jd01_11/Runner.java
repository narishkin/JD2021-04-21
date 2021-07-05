package by.it.marusich.jd01_11;


import java.util.HashSet;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        //List<Integer> listA = new ListA<>();
        //List<Integer> listB=new ListB<>();
        //List<Integer> list2 = new ArrayList<>();
        Set<Integer> setR=new HashSet<>();
        Set<Integer> setC=new SetC<>();


        //listB.add(1); list2.add(1);
        //listB.add(2); list2.add(2);
        //listB.add(3); list2.add(3);
        //listB.add(4); list2.add(4);
        //System.out.println(listB);
        //System.out.println(list2);

        //listB.add(2,8); list2.add(2,8);
        //listB.set(0,0); list2.set(0,0);
        //System.out.println(listB);
        //System.out.println(list2);

        setC.add(1); setR.add(1);
        setC.add(2); setR.add(2);
        setC.add(3); setR.add(3);
        setC.add(4); setR.add(4);
        setC.add(4); setR.add(4);
        System.out.println("add " + setC);
        System.out.println("add " + setR);
        setC.remove(2); setR.remove(2);
        System.out.println("remove " + setC);
        System.out.println("remove " + setR);
        System.out.println("contain " + setC.contains(1));
        System.out.println("contain " + setR.contains(1));
        System.out.println("size " + setC.size());
        System.out.println("size " + setR.size());
        System.out.println("isEmpty " + setC.isEmpty());
        System.out.println("isEmpty " + setR.isEmpty());
        System.out.println("addAll " + setC.addAll(setR));
        System.out.println("addAll " + setR.addAll(setC));
        System.out.println("removeAll " + setC.removeAll(setR));



        //setR.addAll(setC);
        System.out.println(setC);
        System.out.println(setR);




    }
}