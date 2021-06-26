package by.it.marusich.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskA {

    static final String BIN_NAME_FILE = "dataTaskA.bin";
    static final String TXT_NAME_FILE = "resultTaskA.txt";

    static final Random RANDOM = new Random();


    public static void main(String[] args) throws FileNotFoundException {
        String binaryFile = PathCreator.getFileName(TaskA.class, BIN_NAME_FILE);

        writeInFile(binaryFile);
        List<Integer> integerList = readFile(binaryFile);
        printList(integerList);

        String textFile = PathCreator.getFileName(TaskA.class, TXT_NAME_FILE);
        printTextFile(integerList, textFile);


    }

    private static void writeInFile(String fileName) {
        try (DataOutputStream dataOutputStream = new DataOutputStream
                (new BufferedOutputStream
                        (new FileOutputStream(fileName)));
        ) {
            for (int i = 0; i < 20; i++) {
                dataOutputStream.writeInt(RANDOM.nextInt(15));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Integer> readFile(String fileName) {
        List<Integer> integerList = new ArrayList<>();
        try (DataInputStream dataInputStream = new DataInputStream
                (new BufferedInputStream
                        (new FileInputStream(fileName)));
        ) {
            while (dataInputStream.available() > 0) {
                int value = dataInputStream.readInt();
                integerList.add(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integerList;
    }

    private static void printList(List<Integer> integerList) {
        double sum = 0;
        for (Integer integer : integerList) {
            sum += integer;
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println("avg=" + sum / integerList.size());
    }

    private static void printTextFile(List<Integer> integerList, String textFile) {
        try (PrintWriter printWriter = new PrintWriter(textFile);
        ) {
            double sum = 0;
            for (Integer integer : integerList) {
                sum += integer;
                printWriter.print(integer + " ");
            }
            printWriter.println();
            printWriter.println("avg=" + sum/ integerList.size());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
