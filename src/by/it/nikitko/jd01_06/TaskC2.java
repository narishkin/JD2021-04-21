package by.it.nikitko.jd01_06;

import java.util.Random;

public class TaskC2 {

    public static final int WORDS_COUNTS = 50000;
    public static final long RANDOM_SEED = 12345;


    public static void main(String[] args) {


        long lStartTime = System.nanoTime();
        String slowString = slow(Poem.TEXT);
        System.out.println(slowString);
        long lEndTime = System.nanoTime();
        long outputSlow = lEndTime - lStartTime;


        lStartTime = System.nanoTime();
        String fastString = fast(Poem.TEXT);
        System.out.println(fastString);
        lEndTime = System.nanoTime();
        long outputFast = lEndTime - lStartTime;

        System.out.println("Elapsed time in milliseconds slow: " + outputSlow / 1000000);
        System.out.println("Elapsed time in milliseconds fast: " + outputFast / 1000000);
    }


    public static String slow(String text) {
        String[] words = text.split("[^а-яёА-ЯЁ]+");

        Random random = setSeedRandom();

        String string = ("");
        for (int i = 0; i <= WORDS_COUNTS; i++) {
            String addedString = words[random.nextInt(words.length)];
            string = string.concat(addedString).concat(" ");
        }
        return string;
    }


    public static String fast(String text) {
        String[] words = text.split("[^а-яёА-ЯЁ]+");

        Random random = setSeedRandom();

        StringBuilder string = new StringBuilder();
        for (int i = 0; i <= WORDS_COUNTS; i++) {
            String addedString = words[random.nextInt(words.length)];
            string.append(addedString).append(" ");
        }
        return string.toString();
    }

    private static Random setSeedRandom() {
        Random random = new Random();
        random.setSeed(RANDOM_SEED);
        return random;
    }
}
