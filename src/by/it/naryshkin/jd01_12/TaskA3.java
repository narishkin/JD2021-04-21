package by.it.naryshkin.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String s;
        int zeroPos = 0;
        while (!(s= sc.next()).equals("end")){
        Integer value = Integer.valueOf(s);
            if (value>0) {
                list.add(zeroPos++,value);
            } else if (value==0){
                list.add(zeroPos,value);
            } else list.add(value);
        }
        System.out.println(list.toString());
    }
}
