package by.it.nikitko.jd01_06;

import java.util.Arrays;
import java.util.Comparator;


public class TaskB2 {

    public static void main(String[] args) {

        //  String[] sentences = Poem.TEXT.split("[^.][.!?]\\s*");
        String[] sentences = Poem.TEXT.split("\\s*(?<!\\.)\\.(?!\\.)\\s*");
        formatText(sentences);
        sortSentences(sentences);
        printText(sentences);
    }

    private static void formatText(String[] sentences) {
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].replaceAll("[^а-яА-ЯёЁ\\s]", " ").replaceAll("\\s+", " ").trim();
        }
    }

    private static void sortSentences(String[] sentences) {
        Arrays.sort(sentences, (x, y) -> x.length() - y.length());
    }

    private static void printText(String[] sentences) {
        for (String sentence : sentences) {
            System.out.println(sentence);

        }
    }
}



/*      "У лукоморья дуб зелёный Златая цепь на дубе том\n" +
        "Идёт направо песнь заводит Налево сказку говорит\n" +
        "Там на неведомых дорожках Следы невиданных зверей\n" +
        "И днём и ночью кот учёный Всё ходит по цепи кругом\n" +
        "Там чудеса там леший бродит Русалка на ветвях сидит\n" +
        "Избушка там на курьих ножках Стоит без окон без дверей\n" +
        "В темнице там царевна тужит А бурый волк ей верно служит\n");

*/

















