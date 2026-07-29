package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class TypewriterEffect {
    private static final String JAMES_GOSLING_QUOTE = """
            Java - это C++, из которого убрали все пистолеты, ножи и дубинки.
            - James Gosling""";
    private static final String ROBERT_MARTIN_QUOTE = """
            Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.
            - Robert Martin""";
    private static final char[] ADJACENT_PUNCTUATION_MARKS = "!\"'()*,.:;<>?`{}‚…‹›‘’“”¡«»¿".toCharArray();
    private static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        String[] quotes = {
                JAMES_GOSLING_QUOTE,
                ROBERT_MARTIN_QUOTE,
                null,
                ""
        };
        for (String quote : quotes) {
            System.out.println();
            if (quote == null) {
                printDataError();
                continue;
            }
            if (quote.isBlank()) {
                printEmptyStringMessage();
                continue;
            }
            int[][] wordCoordinates = findShortestAndLongestWords(quote);
            String modifiedString = toUpperCaseRange(quote, wordCoordinates);
            typewrite(modifiedString);
        }
    }

    private static void printDataError() {
        System.out.println("Ошибка данных.");
    }

    private static void printEmptyStringMessage() {
        System.out.println("Текст не содержит печатных символов.");
    }

    private static int[][] findShortestAndLongestWords(String string) {
        char[] stringCharacters = string.toCharArray();
        int len = stringCharacters.length;
        int minWordLen = len;
        int shortestWordStart = 0;
        int maxWordLen = 0;
        int longestWordStart = 0;
        for (int i = 0, charactersCount = 0; i < len; i++) {
            if (isWordCharacter(stringCharacters, i, charactersCount)) {
                charactersCount++;
                if (i < len - 1) continue;
                i++;
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

    private static boolean isWordCharacter(char[] string, int i, int charactersCount) {
        if (Character.isLetter(string[i])) return true;
        if (charactersCount > 0) {
            return isPossibleWordCharacter(string[i]);
        }
        for (int j = i; j < string.length; j++) {
            if (Character.isLetter(string[j])) return true;
            if (!isPossibleWordCharacter(string[j])) break;
        }
        return false;
    }

    private static boolean isPossibleWordCharacter(char character) {
        if (Character.isWhitespace(character)) return false;
        for (char punctuationMark : ADJACENT_PUNCTUATION_MARKS) {
            if (character == punctuationMark) return false;
        }
        return true;
    }

    private static String toUpperCaseRange(String string, int[][] wordCoordinates) {
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
            int pause = random.nextInt(150, 500);
            Thread.sleep(pause);
        }
        System.out.println();
    }
}