package by.it._classwork_.jd01_14;

import java.io.*;
import java.util.*;

public class TaskA {

    public static final String FILENAME = "dataTaskA.bin";
    public static final String RESULT_TXT = "resultTaskA.txt";
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String fileName = PathCreator.getFileName(TaskA.class, FILENAME);
        String txtName = PathCreator.getFileName(TaskA.class, RESULT_TXT);

        writeIntegers(fileName);
        List<Integer> integerList = readIntegers(fileName);
        printListConsole(integerList);
        printTxt(txtName, integerList);
    }

    private static void printTxt(String txtName, List<Integer> integerList) {
        try (
                PrintWriter out = new PrintWriter(txtName)
        ) {
            double sum2 = 0;
            for (Integer integer : integerList) {
                sum2 += integer;
                out.printf("%d ", integer);
            }
            out.printf("\navg=%f\n", sum2 / integerList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printListConsole(List<Integer> integerList) {
        double sum = 0;
        for (Integer integer : integerList) {
            sum += integer;
            System.out.printf("%d ", integer);
        }
        System.out.printf("\navg=%f\n", sum / integerList.size());
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
            if (Objects.nonNull(dataInputStream)) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
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
