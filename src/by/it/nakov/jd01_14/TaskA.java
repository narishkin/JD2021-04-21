package by.it.nakov.jd01_14;

import java.io.*;

public class TaskA {
    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }

    public static void main(String[] args) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dir(TaskA.class) + "dataTaskA.bin")));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 25));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try (DataInputStream inputStream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dir(TaskA.class) + "dataTaskA.bin"))); PrintWriter out2 = new PrintWriter(
                                new FileWriter(dir(TaskA.class) + "dataTaskA.bin"))) {
            double summ = 0;
            double count = 0;
            while (inputStream.available() > 0) {
                int i = inputStream.readInt();
                System.out.print(i + " ");
                out2.println(i + " ");
                summ = summ + i;
                count++;
            }
            System.out.println("\navg=" + summ / count);
            out2.println("\navg=" + summ / count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
