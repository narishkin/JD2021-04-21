package by.it.naryshkin.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class TaskA {
    static Random random = new Random();
    static List<Integer> list = new ArrayList<>();
    static String binFilename = dir(TaskA.class) + "dataTaskA.bin";
    static String textFilename = dir(TaskA.class) + "resultTaskA.txt";
    static File file = new File(binFilename);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        intWrite(file);
        list = intRead(file, list);
        Print(list);
    }

    private  static String dir(Class<?> cl){
        String path =  System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path + clDir;
    }

    private static void intWrite(File file) {
        DataOutputStream DOS = null;
        try {
            DOS = new DataOutputStream(new FileOutputStream(file));
            int number;
            for (int i = 0; i < 20; i++) {
                number = random.nextInt(100);
                DOS.writeInt(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (DOS != null){
                try {
                    DOS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static List<Integer> intRead(File file, List list) {

        try (DataInputStream DIS = new DataInputStream(new FileInputStream(file));){
            while (DIS.available()>0) {
                list.add(DIS.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    private static void Print(List<Integer> list) {
        double sum = 0;
        try (PrintWriter PW = new PrintWriter(new FileWriter(textFilename))) {
            for (Integer element : list) {
                sum+=element;
                System.out.printf("%d ", element);
                PW.printf("%d ", element);
            }
            System.out.printf("\navg=%f\n",  sum/list.size());
            PW.printf("\navg=%f\n",  sum/list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
