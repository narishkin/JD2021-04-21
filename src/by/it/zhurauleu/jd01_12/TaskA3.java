package by.it.zhurauleu.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        int zeroPos = 0;
        ArrayList<Integer> myList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        for (; ; ) {
            String value = input.next();
            if (value.equals("end")) {
                break;
            }
            int i = Integer.parseInt(value);
            if (i > 0) {
                myList.add(zeroPos++, i);
            } else if (i < 0) {
                myList.add(i);
            } else {
                myList.add(zeroPos, i);
            }
        }
        System.out.println(myList);
    }
}
