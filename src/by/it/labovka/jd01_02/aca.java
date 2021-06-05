package by.it.labovka.jd01_02;

import java.util.Scanner;

public class aca {
    public static void main(String[] args) {
        int sum=0;
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            sum+=sc.nextInt();
            if(sc.nextInt()==-1) break;
        }
        System.out.println(sum);
        }
}


