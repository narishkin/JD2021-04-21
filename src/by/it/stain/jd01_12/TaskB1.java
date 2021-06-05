package by.it.stain.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String str;
        int pos = 0;
        while (!(str = scanner.next()).equals("end")){
            str = str.replaceAll("[.,:;]","");
            if(!map.containsKey(str)){
                map.put(str,1);
            }else{
                map.put(str,map.get(str)+1);
            }


        }
        for (Map.Entry<String,Integer>compair:map.entrySet()){
            System.out.println(compair.getKey()+"="+compair.getValue());
        }
    }
}
