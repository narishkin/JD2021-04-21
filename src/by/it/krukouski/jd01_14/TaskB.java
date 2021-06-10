package by.it.krukouski.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TaskB {

    static final String POEM = "Poem.txt";

    public static void main(String[] args) throws FileNotFoundException {
        String poemText = PathCreator.getFileName(TaskB.class, POEM);
        File f = new File(poemText);
        Scanner scanner = new Scanner(f);
        int words = 0;
        int marks = 0;
        while (scanner.hasNextLine()){
            String[] strings = scanner.nextLine().replace("-","").split("\\s");
            words+=strings.length;
        }
        System.out.println("words= " + words);



    }

}
