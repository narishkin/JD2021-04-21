package by.it.sapazhkou.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class TaskA {

    public static void main(String[] args) {

        String root = System.getProperty("user.dir");
        Class<TaskA> aClass = TaskA.class;
        String pathProject = aClass.getName().
                replace(aClass.getSimpleName(), "").
                replace(".", File.separator);
        String pathFile = root + File.separator + "src" + File.separator + pathProject + "dataTaskA.bin";
        String pathFileResult = root + File.separator + "src" + File.separator + pathProject + "resultTaskA.txt";

// write file
        try (DataOutputStream dataOutputStream = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(pathFile)
                )
        )
        ) {
            for (int i = 0; i < 20; i++) {
                dataOutputStream.writeInt(new Random().nextInt(1000));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

// read to ArrayList

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        try (DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(pathFile)
                )
        )
        ) {
            while (dataInputStream.available() > 0) {
                integerArrayList.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

// Array to console end avg

        double sum = 0;

        for (Integer element : integerArrayList) {
            sum = sum + element;
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("avg=" + sum / integerArrayList.size());

// result to resultTaskA.txt
        try (
                PrintWriter printWriter = new PrintWriter(pathFileResult);
        ) {
            double sum2 = 0;
            for (int i = 0; i < integerArrayList.size(); i++) {
                printWriter.print(integerArrayList.get(i)+" ");
                sum2 = sum2 + integerArrayList.get(i);
            }
            printWriter.print("\n"+"avg="+ sum2 / integerArrayList.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
