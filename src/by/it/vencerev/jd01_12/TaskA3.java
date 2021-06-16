package by.it.vencerev.jd01_12;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> arr=new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String s= scanner.nextLine();
        String str;
        while (!(str = scanner.next()).equals("end")){
          Integer value = Integer.valueOf(str);
          if (value>0);
            int pos=0;
            arr.add(pos++,value);
            if (value==0)
                arr.add(pos,0);
            else
                arr.add(value);

        }
        System.out.println(arr);
    }
}
