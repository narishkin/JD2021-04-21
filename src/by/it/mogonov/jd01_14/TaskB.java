package by.it.mogonov.jd01_14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TaskB {
    public static final String FILENAME2 = "Poem.txt";
    //public static final String RESULT2 = "resultTaskB.txt";


    public static void main(String[] args) throws IOException {

        String fileName2 = PathCreator.getFileName(FILENAME2);
       // String txtName2 = PathCreator.getFileName(RESULT2);


        Stream<String> lines3 =
                Files.lines(Paths.get(fileName2));

        long simblCount = lines3
                .flatMap(s -> Stream.of(s.replaceAll("[а-яА-ЯёЁ]+", ""))
                        .filter(t -> !t.isEmpty()))
                .map(t -> t.replaceAll(" ", ""))
                //.flatMap(t -> Arrays.stream(t.toCharArray()))
                .count();
        Stream<String> lines2 =
                Files.lines(Paths.get(fileName2));

        long wordsCount = lines2
                .flatMap(s -> Stream.of(s.replaceAll("[\\.\\,\\-:;!?]","")).filter(t -> !t.isEmpty()))
                .map(t -> t.replaceAll(" ", ""))

                .count();

        System.out.println("words=" + wordsCount + ", " + "punctuation marks=" + simblCount);
    }
}


