package by.it.nikitko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static final String WORD_PATTERN = "[-.,а-яёА-ЯЁ]+";


    public static void main(String[] args) {

        String[] poemByString = Poem.TEXT.split("\n");
        System.out.println(poemByString[4]);
        int maxLenght = findMaxString(poemByString);
        formatString(poemByString, maxLenght);

    }


    private static void formatString(String[] poemByString, int maxLenght) {


        int spaceNeeded = maxLenght - poemByString[4].length();
        int wordsInSentence = foundCountOfWords(poemByString[4]);

        int firstSpaceCount = 0;
        int otherSpaceCount = 0;

        if (spaceNeeded % (wordsInSentence - 1) == 0) {
            firstSpaceCount = otherSpaceCount = spaceNeeded / (wordsInSentence - 1);
        } else {
            firstSpaceCount = spaceNeeded / (wordsInSentence - 1) + 1;
            otherSpaceCount = spaceNeeded / (wordsInSentence - 1);
        }


        StringBuilder string = new StringBuilder(poemByString[4]);
        Pattern patternWord = Pattern.compile(WORD_PATTERN);
        Matcher matcher = patternWord.matcher(string);
        while (matcher.find() && !matcher.hitEnd()) {
            int position = matcher.end();




            if ((spaceNeeded % (wordsInSentence - 1) != 0) ) {
                for (int i = 0; i < firstSpaceCount; i++) {
                    string.insert(position, ' ');
                    spaceNeeded--;
                }
                wordsInSentence--;
            }

            if ((spaceNeeded % (wordsInSentence - 1)) == 0) {
                for (int i = 0; i < otherSpaceCount; i++) {
                    string.insert(position, ' ');
                    spaceNeeded--;
                }
            }


        }
        System.out.println(string);
        System.out.println("Там русский дух... там Русью пахнет!");
        ;


        System.out.println("lenght of current string =" + poemByString[4].length());
        System.out.println("spaceNeeded=" + spaceNeeded);
        System.out.println("wordsInSentence=" + wordsInSentence);
        //  System.out.println("firstSpaceCount=" + firstSpaceCount);
        //  System.out.println("otherSpaceCount=" + otherSpaceCount);


    }

    private static int foundCountOfWords(String poemByString) {
        int wordsInSentence = 0;
        StringBuilder string = new StringBuilder(poemByString);
        Pattern patternWord = Pattern.compile(WORD_PATTERN);
        Matcher matcher = patternWord.matcher(string);
        while (matcher.find()) {
            wordsInSentence++;
        }
        return wordsInSentence;
    }

    private static int findMaxString(String[] poemByString) {
        int maxLenght = 0;
        for (String s : poemByString) {
            if (s.length() > maxLenght) {
                maxLenght = s.length();
            }
        }
        System.out.println("maxLenght=" + maxLenght);
        return maxLenght;
    }

}
/*
                        "У     лукоморья     дуб     зелёный,\n" +
                        "Златая    цепь    на    дубе    том.\n" +
                        "И    днём   и   ночью   кот   учёный\n" +
                        "Всё    ходит    по    цепи   кругом.\n" +
                        "Идёт   направо   -   песнь  заводит,\n" +
                        "Налево     -     сказку     говорит.\n" +
                        "Там   чудеса:   там   леший  бродит,\n" +
                        "Русалка     на     ветвях     сидит.\n" +
                        "Там     на     неведомых    дорожках\n" +
                        "Следы       невиданных       зверей.\n" +
                        "Избушка   там   на   курьих   ножках\n" +
                        "Стоит    без   окон,   без   дверей.\n" +
                        "Там   лес   и   дол  видений  полны,\n" +
                        "Там    о    заре   прихлынут   волны\n" +
                        "На    брег    песчаный   и   пустой,\n" +
                        "И    тридцать   витязей   прекрасных\n" +
                        "Чредой   из   вод   выходят   ясных,\n" +
                        "И   с   ними   дядька   их  морской.\n" +
                        "Там        королевич       мимоходом\n" +
                        "Пленяет        грозного        царя.\n" +
                        "Там    в   облаках   перед   народом\n" +
                        "Через      леса,      через     моря\n" +
                        "Колдун        несёт        богатыря.\n" +
                        "В   темнице   там   царевна   тужит,\n" +
                        "А   бурый   волк  ей  верно  служит.\n" +
                        "Там     ступа     с    Бабою    Ягой\n" +
                        "Идёт,     бредёт     сама     собой.\n" +
                        "Там  царь  Кащей  над златом чахнет,\n" +
                        "Там русский дух... там Русью пахнет!\n" +
                        "И   там   я   был,   и  мёд  я  пил,\n" +
                        "У    моря    видел    дуб   зелёный,\n" +
                        "Под   ним   сидел,   и   кот  учёный\n" +
                        "Свои     мне     сказки     говорил.");
 */