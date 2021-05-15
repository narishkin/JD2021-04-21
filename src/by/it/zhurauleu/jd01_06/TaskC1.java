package by.it.zhurauleu.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    private static final String LINE_PATTERN = ".[^\\n]+";

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.TEXT);
        int maxLineLength = getLineMaxLength(text);
        Pattern linePattern = Pattern.compile(LINE_PATTERN);
        Matcher lineMatcher = linePattern.matcher(text);
        while (lineMatcher.find()) {
            String justifyLine = justifyLine(lineMatcher.group(), maxLineLength);
            System.out.println(justifyLine);
        }
    }

    private static String justifyLine(String line, int targetLength) {
        StringBuilder text = new StringBuilder(line);
        int deficientBlankCount = targetLength - line.length();
        int start = 0;
        int iteration = 0;
        for (int i = 0; i < deficientBlankCount; i++) {
            start = text.indexOf(" ", start);
            if (start < 0) {
                iteration++;
                start = text.indexOf(" ", 0);
            }
            text.replace(start, start + 1, "  ");
            start = start + (iteration + 2);
        }
//        System.out.println(text);
        return text.toString();
    }

    public static int getLineMaxLength(StringBuilder text) {
        int maxLineLength = 0;
        Pattern pattern = Pattern.compile(LINE_PATTERN);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            maxLineLength = Math.max(maxLineLength, matcher.group().length());
        }
        return maxLineLength;
    }
}
