package com.startjava.lesson_2_3.method.naming;

public class Main {
    public static void main(String[] args) {
        printNonBmDescription();
        printBmDescription();
    }

    public static void printNonBmDescription() {
        System.out.println("\nНЕ BOOLEAN-МЕТОДЫ:\n");

        NonBooleanMethods nonBm = new NonBooleanMethods();

        nonBm.findLongestWord();
        nonBm.selectMenuItem();
        nonBm.calculateAvgMark();
        nonBm.countUniqueWords();
        nonBm.printErrorMessage();
        nonBm.syncData();
        nonBm.restoreBackup();
        nonBm.pauseDownload();
        nonBm.resetFactorySettings();
        nonBm.writeToFile();
        nonBm.convertCelsiusToFahrenheit();
        nonBm.enterMathExpression();
        nonBm.determineWinner();
        nonBm.findBooksByAuthor();
    }

    public static void printBmDescription() {
        System.out.println("\nBOOLEAN-МЕТОДЫ:\n");

        BooleanMethods bm = new BooleanMethods();

        System.out.println(bm.isRunning());
        System.out.println(bm.hasUniqueDigit());
        System.out.println(bm.isLetter());
        System.out.println(bm.hasEqualDigits());
        System.out.println(bm.hasAttempts());
        System.out.println(bm.isBlank());
        System.out.println(bm.isEven());
        System.out.println(bm.isValidPath());
        System.out.println(bm.isExistFile());
    }
}