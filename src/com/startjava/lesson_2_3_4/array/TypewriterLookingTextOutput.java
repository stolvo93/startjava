package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class TypewriterLookingTextOutput {
    private static final String JAMES_GOSLING_QUOTE = """
            Java - это C++, из которого убрали все пистолеты, ножи и дубинки.
            - James Gosling""";
    private static final String ROBERT_MARTIN_QUOTE = """
            Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.
            - Robert Martin""";
    private static final Random RND = new Random();

    public static void main(String[] args) throws InterruptedException {
        String[] strings = {
                JAMES_GOSLING_QUOTE,
                ROBERT_MARTIN_QUOTE,
                null,
                ""
        };
        for (String string : strings) {
            System.out.println();
            if (string == null) {
                printDataError();
                continue;
            }
            if (string.isEmpty()) {
                printEmptyStringMessage();
                continue;
            }
            int[][] wordCoordinates = findShortestAndLongestWords(string);
            String modifiedString = capitalizeLettersBetweenWords(string, wordCoordinates);
            typewrite(modifiedString);
        }
    }

    private static void printDataError() {
        System.out.println("Ошибка данных.");
    }

    private static void printEmptyStringMessage() {
        System.out.println("В качестве аргумента подана пустая строка.");
    }

    private static int[][] findShortestAndLongestWords(String string) {
        char[] stringCharacters = string.toCharArray();
        int len = stringCharacters.length;
        int minWordLen = len;
        int shortestWordStart = 0;
        int maxWordLen = 0;
        int longestWordStart = 0;
        for (int i = 0, charactersCount = 0; i < len; i++) {
            if (Character.isLetter(stringCharacters[i])) {
                charactersCount++;
                if (i < len - 1) continue;
                else i++;
            }
            if (charactersCount > 0 && charactersCount < minWordLen) {
                minWordLen = charactersCount;
                shortestWordStart = i - charactersCount;
            }
            if (charactersCount > maxWordLen) {
                maxWordLen = charactersCount;
                longestWordStart = i - charactersCount;
            }
            charactersCount = 0;
        }

        int[][] coordinates = {
                {shortestWordStart, minWordLen},
                {longestWordStart, maxWordLen}
        };
        return coordinates;
    }

    private static String capitalizeLettersBetweenWords(String string, int[][] wordCoordinates) {
        int start = Integer.MAX_VALUE;
        int end = 0;
        for (int[] word : wordCoordinates) {
            int wordStart = word[0];
            int wordLen = word[1];
            start = Math.min(start, wordStart);
            end = Math.max(end, wordStart + wordLen);
        }

        char[] modifiedString = string.toCharArray();
        for (int i = start; i < end; i++) {
            modifiedString[i] = Character.toUpperCase(modifiedString[i]);
        }
        return String.valueOf(modifiedString);
    }

    private static void typewrite(String text) throws InterruptedException {
        Thread.sleep(1000);
        char[] textCharacters = text.toCharArray();
        for (char character : textCharacters) {
            System.out.print(character);
            int pause = RND.nextInt(150, 500);
            Thread.sleep(pause);
        }
        System.out.println();
    }
}