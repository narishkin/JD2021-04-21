package by.it.marusich.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int positionZero = 0;
        for (;;){
            String value = sc.next();
            if (value.equals("end")){
                break;
            }
            int i = Integer.parseInt(value);
            if (i>0){
                list.add(positionZero++,i);
            } else if (i==0){
                list.add(positionZero,i);
            } else {
                list.add(i);
            }
        }
        System.out.println(list);

    }
}
