package by.it.nikitko.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA {

    private static final String BIN_FILE_NAME = "dataTaskA.bin";
    private static final String TXT_FILE_NAME = "resultTaskA.txt";

    public static void main(String[] args) throws IOException {

        writeBinFile();
        List<Integer> integerList=readBinFile();
        print(integerList);

    }

    private static void writeBinFile() {
        try (DataOutputStream dos = new DataOutputStream
                (new BufferedOutputStream(new FileOutputStream
                        (PathCreator.getPath(TaskA.class) + BIN_FILE_NAME)))) {
            Random random = new Random();
            for (int i = 0; i < 20; i++) {
                dos.writeInt(random.nextInt(10000));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> readBinFile() {
        List<Integer> integerList = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream
                (new BufferedInputStream(new FileInputStream
                        (PathCreator.getPath(TaskA.class) + BIN_FILE_NAME)))) {
            while (dis.available() > 0) {
                int i = dis.readInt();
                integerList.add(i);
            }
            return integerList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integerList;
    }


    public static void print(List<Integer> integerList) throws IOException {

        PrintWriter printWriter = new PrintWriter(new FileWriter(PathCreator.getPath(TaskA.class) + TXT_FILE_NAME));
        double sum = 0;
        double counter = 0;
        Iterator<Integer> iteratorList = integerList.iterator();

        while (iteratorList.hasNext()) {
            int i = iteratorList.next();
            System.out.print(i + " ");
            printWriter.print(i + " ");
            sum += i;
            counter++;
        }
        System.out.println("avg=" + sum / counter);
        printWriter.print("avg=" + sum / counter);
    }


}

