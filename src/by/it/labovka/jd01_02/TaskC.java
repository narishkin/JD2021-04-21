package by.it.labovka.jd01_02;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
      step1(n);

    }
    public static int[][] step1(int n)
    {
        int arr[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = -n + (int) (Math.random() * ((n - (-n)) + 1));
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
        return arr;
    }
   public static void step2(int[ ][ ] arr) {
       int s1 = 0;
       int s2 = 0;
       ArrayList<Integer> list1 = new ArrayList<Integer>();
       ArrayList<Integer> list2 = new ArrayList<Integer>();
       ArrayList<Integer> list3 = new ArrayList<Integer>();
       boolean isFull = false;
       for (int i = 0; i < arr.length; i++) {
           for (int j = 0; j < arr.length; j++) {
               for (int k = 0; k < arr.length; k++) {
                  if(list2.size()>2) continue;
               }

           }
       }

//       if (arr[i][j] > 0 && i == 0) list1.add(arr[i][j]);
//       if (arr[i][j] > 0 && i == 1) list2.add(arr[i][j]);
////       if (arr[i][j] > 0 && i == 2) list3.add(arr[i][j]);
//       for (int i = 0; i < arr.length; i++) {
//           for (int j = 0; j < arr.length; j++) {
//
//           }
//       }
   }
}