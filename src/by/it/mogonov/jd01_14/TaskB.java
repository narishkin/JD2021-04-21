package by.it.mogonov.jd01_14;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TaskB {
    public static final String FILENAME = "Poem.txt";
    public static final String RESULT = "resultTaskB.txt";


    public static void main(String[] args) throws IOException {

        String fileName = PathCreator.getFileName(TaskB.class, FILENAME);
        String txtName = PathCreator.getFileName(TaskB.class, RESULT);
        printTxt(txtName);

        Stream<String> lines3 =
                Files.lines(Paths.get(fileName));

        long simblCount = lines3
                .flatMap(s -> Stream.of(s.replaceAll("[а-яА-ЯёЁ]", "")))
                .map(t -> t.replaceAll(" ", ""))
                .map(t -> t.replaceAll("\\.{3}", "\\."))
                .filter(t -> !t.isEmpty())
                .flatMapToInt(t -> t.chars())
                .mapToObj(i -> (char) i)
                //.peek(t -> System.out.println(t))
                .count();


        int wordsCount = 0;
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        byte[] bytesArray = new byte[(int) file.length()];
        fis.read(bytesArray);
        String s = new String(bytesArray);
        String[] data = s.split("[^а-яА-ЯёЁ]+");
        for (int i = 0; i < data.length; i++) {
            wordsCount++;

        }
        txtName = "words=" + wordsCount + ", " + "punctuation marks=" + simblCount;
        printTxt(txtName);
        System.out.println("words=" + wordsCount + ", " + "punctuation marks=" + simblCount);
    }


   private static void printTxt(final String txtName) throws IOException {

        PrintWriter fileWriter = new PrintWriter(RESULT);
      fileWriter.println(txtName);
       fileWriter.close();

        FileWriter fw = new FileWriter(txtName,false );
       fw.write(txtName);
        fw.write(txtName);
        fw.flush();
        fw.close();

    }

}


