package by.it.zhurauleu.jd01_14;

import java.io.*;
import java.util.*;

public class TaskA {

    public static final String BIN_FILE_NAME = "dataTaskA.bin";
    public static final String TXT_FILE_NAME = "resultTaskA.txt";
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String binFilePath = PathCreator.getFileName(TaskA.class, BIN_FILE_NAME);
        String txtFilePath = PathCreator.getFileName(TaskA.class, TXT_FILE_NAME);
        writeIntegers(binFilePath);
        readIntegers(binFilePath);
        List<Integer> integerList = readIntegers(binFilePath);
        printToConsole(integerList);
        PrintToTxt(txtFilePath, integerList);
   }

    private static void PrintToTxt(String txtFileName, List<Integer> integerList) {
        try (
                PrintWriter printWriter = new PrintWriter(txtFileName)
        ) {
            double sum = 0;
            for (Integer integer : integerList) {
                sum += integer;
                printWriter.printf("%d ", integer);
            }
            printWriter.printf("\n%f", sum/integerList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printToConsole(List<Integer> integerList) {
        double sum = 0;
        for (Integer integer : integerList) {
            sum += integer;
            System.out.printf("%d ", integer);
        }
        System.out.printf("\navg=%f\n", sum / integerList.size());
    }

    private static List<Integer> readIntegers(String FilePath) {
        List<Integer> integerList = new ArrayList<>();
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(FilePath)
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


    private static void writeIntegers(String filePath) {
        try (
                DataOutputStream dataOutputStream = new DataOutputStream(
                        new BufferedOutputStream(new
                                FileOutputStream(filePath)
                        )
                )
        ) {
            for (int i = 0; i < 20; i++) {
                dataOutputStream.writeInt(RANDOM.nextInt(500));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
