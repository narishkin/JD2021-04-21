package by.it.nikitko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static final String WORD_PATTERN = "[-.,а-яёА-ЯЁ:]+";


    public static void main(String[] args) {

        String[] poemByString = Poem.TEXT.split("\n");
        int maxLength = findMaxString(poemByString);
       for (String stringI : poemByString) {
            formatString(stringI, maxLength);
       }
      //    formatString(poemByString[29], maxLength);
    }


    private static void formatString(String stringI, int maxLength) {
        int spaceNeeded = maxLength - stringI.length();
        StringBuilder string = new StringBuilder(stringI);

        Pattern patternWord = Pattern.compile(WORD_PATTERN);
        Matcher matcher = patternWord.matcher(string);

        while (spaceNeeded > 0) {
            matcher.reset();
            int position=0;
            while (matcher.find(position) && !matcher.hitEnd()&&spaceNeeded>0) {
                position = matcher.end();
                string.insert(position, ' ');
                spaceNeeded--;
            }
        }
        System.out.println(string);

    }

    private static int findMaxString(String[] poemByString) {
        int maxLength = 0;
        for (String s : poemByString) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }
        return maxLength;
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