package by.it.mogonov.jd01_14;

import java.io.*;
import java.util.*;

public class TaskA {

    public static final String FILENAME = "dataTaskA.bin";
    public static final String RESULT = "resultTaskA.txt";
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {

        String fileName = PathCreator.getFileName(TaskA.class,FILENAME);
        String txtName = PathCreator.getFileName(TaskA.class,RESULT);

        writeIntegers(fileName);
        List<Integer> integerList = readIntegers(fileName);
        printListConsole(integerList);
        printTxt(txtName, integerList);
    }

    public static void printTxt(String txtName, List<Integer> integerList) {
        try (
                PrintWriter out = new PrintWriter(txtName);
        ) {
            double sum2 = 0;
            for (Integer integer : integerList) {
                sum2 += integer;
                out.printf("%d ", integer);

            }
            out.println("avg=" + sum2 / integerList.size());
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void printListConsole(List<Integer> integerList) {
        double sum = 0;
        for (Integer integer : integerList) {
            sum += integer;
            System.out.printf("%d ", integer);
        }
        System.out.println("avg="+ sum / integerList.size());
    }

    private static List<Integer> readIntegers(String fileName) {
        List<Integer> integerList = new ArrayList<>();
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(fileName)
                    )
            );
            while (dataInputStream.available() > 0) {
                int value = dataInputStream.readInt();
                integerList.add(value);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (dataInputStream!=null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return integerList;
    }


    private static void writeIntegers(String fileName) {
        try (
                DataOutputStream dataOutputStream = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(fileName)
                        )
                )
        ) {
            for (int i = 0; i < 20; i++) {
                dataOutputStream.writeInt(RANDOM.nextInt(10000));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}




