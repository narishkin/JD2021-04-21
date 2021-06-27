package by.it.mogonov.jd01_14;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskB {
    public static final String FILENAME = "Poem.txt";
    public static final String RESULT = "resultTaskB.txt";


    public static void main(String[] args) throws IOException {

        String fileName = PathCreator.getFileName(TaskB.class, FILENAME);

        List<String> lines =
                Files.lines(Paths.get(fileName)).collect(Collectors.toList());

        long simblCount = lines.stream()
                .flatMap(s -> Stream.of(s.replaceAll("[а-яА-ЯёЁ]", "")))
                .map(t -> t.replaceAll(" ", ""))
                .map(t -> t.replaceAll("\\.{3}", "\\."))
                .filter(t -> !t.isEmpty())
                .flatMapToInt(t -> t.chars())
                .mapToObj(i -> (char) i)
                .count();


        long wordsCount = lines.stream().flatMap(line -> Stream.of(line.split("[^а-яА-ЯёЁ]+"))).count();
        String result = "words=" + wordsCount + ", " + "punctuation marks=" + simblCount;
        printTxt(result);
    }


    private static void printTxt(final String txtName) throws IOException {

        System.out.println(txtName);

        FileWriter fw = new FileWriter(PathCreator.getFileName(TaskB.class, RESULT), false);
        fw.write(txtName);
        fw.flush();
        fw.close();

    }

}