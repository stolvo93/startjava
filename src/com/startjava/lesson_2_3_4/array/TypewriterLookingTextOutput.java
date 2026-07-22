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
        // String[] words = findShortestAndLongestWords("    топ топич  топ    ");
        // System.out.println(Arrays.toString(words));
        // String shortestWord = words[0];
        // String longestWord = words[1];

        int[][] wordCoordinates = findShortestAndLongestWords(arguments[0]);
        String capitalizedString = capitalizeLettersBetweenWords (arguments[0], wordCoordinates);
        System.out.println(capitalizedString);
    }

    private static int[][] findShortestAndLongestWords(String string) {
        char[] stringChars = string.toCharArray();
        int len = stringChars.length;
        int minWordLen = len;
        int minWordStart = 0;
        int maxWordLen = 0;
        int maxWordStart = 0;
        for (int i = 0, charsCount = 0; i < len; i++) {
            if (Character.isLetter(stringChars[i])) {
                charsCount++;
                if (i < len - 1) continue;
                else i++;
            }
            if (charsCount > 0 && charsCount < minWordLen) {
                minWordLen = charsCount;
                minWordStart = i - charsCount;
            }
            if (charsCount > maxWordLen) {
                maxWordLen = charsCount;
                maxWordStart = i - charsCount;
            }
            charsCount = 0;
        }
        // String shortestWord = extractWord(stringChars, minWordStart, minWordLen);
        // String longestWord = extractWord(stringChars, maxWordStart, maxWordLen);
        // String[] result = {shortestWord, longestWord};

        int[][] indexes = {
                {minWordStart, minWordLen},
                {maxWordStart, maxWordLen}
        };
        return indexes;
    }

    // private static String extractWord(char[] charSequence, int start, int len) {
    //     char[] word = new char[len];
    //     for (int i = 0, j = start; i < len; i++, j++) {
    //         word[i] = charSequence[j];
    //     }
    //     return String.valueOf(word);
    // }

    private static String capitalizeLettersBetweenWords(String string, int[][] wordCoordinates) {
        int minWordStart = wordCoordinates[0][0];
        int minWordLen = wordCoordinates[0][1];
        int maxWordStart = wordCoordinates[1][0];
        int maxWordLen = wordCoordinates[1][1];
        int start = 0;
        int end = 0;
        if (minWordStart < maxWordStart) {
            start = minWordStart;
            end = maxWordStart + maxWordLen;
        } else {
            start = maxWordStart;
            end = minWordStart + minWordLen;
        }

        char[] stringChars = string.toCharArray();
        for (int i = start; i < end; i++) {
            stringChars[i] = Character.toUpperCase(stringChars[i]);
        }

        String capitalized = String.valueOf(stringChars);
        return capitalized;
    }
}