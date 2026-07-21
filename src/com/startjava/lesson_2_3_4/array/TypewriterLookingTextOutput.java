package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TypewriterLookingTextOutput {
    private static final String JAMES_GOSLING_QUOTE = """
            Java - это C++, из которого убрали все пистолеты, ножи и дубинки.
            - James Gosling""";
    private static final String ROBERT_MARTIN_QUOTE = """
            Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.
            - Robert Martin""";

    public static void main(String[] args) {
        String[] arguments = {
                JAMES_GOSLING_QUOTE,
                ROBERT_MARTIN_QUOTE,
                null,
                ""
        };
        String[] words = findShortestAndLongestWords(arguments[1]);
        System.out.println(Arrays.toString(words));
    }

    private static String[] findShortestAndLongestWords(String string) {
        char[] stringChars = string.toCharArray();
        int maxWordLen = 0;
        int maxWordStart = 0;
        int minWordLen = stringChars.length;
        int minWordStart = 0;
        for (int i = 0, charsCount = 0; i < stringChars.length; i++) {
            if (Character.isLetter(stringChars[i])) {
                charsCount++;
                continue;
            }
            if (charsCount > maxWordLen) {
                maxWordLen = charsCount;
                maxWordStart = i - charsCount;
            } else if (charsCount > 0 && charsCount < minWordLen) {
                minWordLen = charsCount;
                minWordStart = i - charsCount;
            }
            charsCount = 0;
        }
        String shortestWord = extractWord(stringChars, minWordStart, minWordLen);
        String longestWord = extractWord(stringChars, maxWordStart, maxWordLen);
        String[] result = {shortestWord, longestWord};
        return result;
    }

    private static String extractWord(char[] charSequence, int start, int len) {
        char[] word = new char[len];
        for (int i = 0, j = start; i < len; i++, j++) {
            word[i] = charSequence[j];
        }
        return String.valueOf(word);
    }
}