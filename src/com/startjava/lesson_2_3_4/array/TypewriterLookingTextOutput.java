package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class TypewriterLookingTextOutput {
    private static final String JAMES_GOSLING_QUOTE = """
            Java - это C++, из которого убрали все пистолеты, ножи и дубинки.
            - James Gosling""";
    private static final String ROBERT_MARTIN_QUOTE = """
            Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.
            - Robert Martin""";
    private static final int SHORTEST_WORD = 0;
    private static final int LONGEST_WORD = 1;
    private static final int START = 0;
    private static final int LEN = 1;
    private static final Random RND = new Random();

    public static void main(String[] args) throws InterruptedException {
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
        String string = "ТЫ ПИД\b \b\b \b\b \bКРАСАВЧИК!";
        // int[][] wordCoordinates = findShortestAndLongestWords(string);
        // String capitalizedString = capitalizeLettersBetweenWords(string, wordCoordinates);
        System.out.println("\n\n\n\n\n\n\n\n");
        System.out.print("                                      ");
        typeWrite(string);
        System.out.println("\n\n\n\n\n\n\n\n");
    }

    private static int[][] findShortestAndLongestWords(String string) {
        char[] stringCharacters = string.toCharArray();
        int len = stringCharacters.length;
        int minWordLen = len;
        int shortestWordStart = 0;
        int maxWordLen = 0;
        int longestWordStart = 0;
        for (int i = 0, charsCount = 0; i < len; i++) {
            if (Character.isLetter(stringCharacters[i])) {
                charsCount++;
                if (i < len - 1) continue;
                else i++;
            }
            if (charsCount > 0 && charsCount < minWordLen) {
                minWordLen = charsCount;
                shortestWordStart = i - charsCount;
            }
            if (charsCount > maxWordLen) {
                maxWordLen = charsCount;
                longestWordStart = i - charsCount;
            }
            charsCount = 0;
        }
        // String shortestWord = extractWord(stringCharacters, shortestWordStart, minWordLen);
        // String longestWord = extractWord(stringCharacters, longestWordStart, maxWordLen);
        // String[] result = {shortestWord, longestWord};

        // int[][] indexes = {
        //         {shortestWordStart, minWordLen},
        //         {longestWordStart, maxWordLen}
        // };
        int[][] coordinates = new int[2][2];
        coordinates[SHORTEST_WORD][START] = shortestWordStart;
        coordinates[SHORTEST_WORD][LEN] = minWordLen;
        coordinates[LONGEST_WORD][START] = longestWordStart;
        coordinates[LONGEST_WORD][LEN] = maxWordLen;
        return coordinates;
    }

    // private static String extractWord(char[] charSequence, int start, int len) {
    //     char[] word = new char[len];
    //     for (int i = 0, j = start; i < len; i++, j++) {
    //         word[i] = charSequence[j];
    //     }
    //     return String.valueOf(word);
    // }

    private static String capitalizeLettersBetweenWords(String string, int[][] wordCoordinates) {
        int firstWordStart = wordCoordinates[0][0];
        int firstWordLen = wordCoordinates[0][1];
        int secondWordStart = wordCoordinates[1][0];
        int secondWordLen = wordCoordinates[1][1];
        int start = 0;
        int end = 0;
        if (firstWordStart < secondWordStart) {
            start = firstWordStart;
            end = secondWordStart + secondWordLen;
        } else {
            start = secondWordStart;
            end = firstWordStart + firstWordLen;
        }

        char[] stringCharacters = string.toCharArray();
        for (int i = start; i < end; i++) {
            stringCharacters[i] = Character.toUpperCase(stringCharacters[i]);
        }

        String capitalized = String.valueOf(stringCharacters);
        return capitalized;
    }

    private static void typeWrite(String text) throws InterruptedException {
        char[] textCharacters = text.toCharArray();
        Thread.sleep(1000);
        // for (char character : textCharacters) {
        //     Thread.sleep(pause);
        //     System.out.print(character);
        // }
        for (int i = 0; i < textCharacters.length; i++) {
            if (i > 0 && (textCharacters[i - 1] == '\b' && textCharacters[i] == ' ' ||
                    textCharacters[i - 1] == ' ' && textCharacters[i] == '\b')) {
                System.out.print(textCharacters[i]);
            } else {
                int pause = RND.nextInt(200, 1000);
                Thread.sleep(pause);
                System.out.print(textCharacters[i]);
            }
        }
        Thread.sleep(500);
        System.out.println();
    }
}