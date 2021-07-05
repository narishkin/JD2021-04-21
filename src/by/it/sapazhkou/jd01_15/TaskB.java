package by.it.sapazhkou.jd01_15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Comment in format JavaDoc
 *
 * @author Sapazhkou Mikhail
 */
public class TaskB {

/*
Класс удаляет все комментарии из файла класса
 */

    public static void main(String[] args) {
// Читать файл в SB и удалять комментарии

        String filePath = PathCreator.getPathName(TaskB.class, "TaskB.java");
        String fileResult = PathCreator.getPathName(TaskB.class, "TaskB.txt");
        readFromFile(filePath);
        System.out.println(readFromFile(filePath));
        saveToFile(readFromFile(filePath), fileResult);

// Вывод результата в консоль и файл

    }

    private static void saveToFile(StringBuilder readFromFile, String fileResult) {

        try (
                PrintWriter printWriter = new PrintWriter(fileResult);
        ) {
            printWriter.print(readFromFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static StringBuilder readFromFile(String filePath) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbResult = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean strDel = false;
            while ((line = bufferedReader.readLine()) != null) {
                char[] stringCurrent = line.toCharArray();
                char charCurrent = '\u0000';
                for (int i = 0; i < stringCurrent.length; i++) {
                    if (strDel) {
                        strDel = false;
                        sb.delete(0, line.length());
                        break;
                    }
                    if (stringCurrent[i] == '/' && charCurrent != '/') {
                        charCurrent = '/';
                        if (i == stringCurrent.length - 1) {
                            sb.append(stringCurrent[i]);
                        }
                        continue; //это тоже комментарий
                    } else if (stringCurrent[i] == '/' && charCurrent == '/') {
                        break;
                    } else if (stringCurrent[i] != '/' && charCurrent == '/') {
                        if (stringCurrent[i] == '\u002A') {
                            charCurrent = '\u002A';
                            strDel = true;
                            continue;
                        }
                        if (charCurrent != '\u0000') {
                            sb.append(charCurrent);
                            charCurrent = '\u0000';
                        }
                    } else if (stringCurrent[i] == '\u002A') {
                        sb.delete(0, line.length());
                        break;
                    }
                    sb.append(stringCurrent[i]);
                }
                sbResult.append(sb);
                sbResult.append('\n');
                sb.delete(0, line.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sbResult;
    }
}

/*
Выполнение завершено
 */