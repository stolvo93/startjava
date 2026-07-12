package com.startjava.lesson_2_3_4.array;

public class ArrayCleansing {
    public static void main(String[] args) {
        int arraysLength = 15;
        double[] originalArray = generateFractionsArray(arraysLength);
        int[] indexes = {-1, 15, 0, 14};

        for (int index : indexes) {
            System.out.println();
            if (index < 0 || index >= arraysLength) {
                printWrongIndexError(index, arraysLength - 1);
                continue;
            }
            double[] cleansedArray = cleanseLargerElementsByIndex(originalArray, index);
            printArray(originalArray, "Исходный массив:");
            printArray(cleansedArray, "Измененный массив:");
            printElement(originalArray, index);
        }
    }

    private static double[] generateFractionsArray(int length) {
        double[] fractionsArray = new double[length];
        for (int i = 0; i < length; i++) {
            fractionsArray[i] = Math.random();
        }
        return fractionsArray;
    }

    private static void printWrongIndexError(int index, int maxIndex) {
        System.out.printf("Ошибка: индекс массива %d недопустим. " +
                "Выберите значение от 0 до %d.%n", index, maxIndex);
    }

    private static double[] cleanseLargerElementsByIndex(double[] originalArray, int index) {
        double[] cleansedArray = new double[originalArray.length];
        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i] <= originalArray[index]) {
                cleansedArray[i] = originalArray[i];
            }
        }
        return cleansedArray;
    }

    private static void printArray(double[] array, String... arrayName) {
        if (arrayName != null) {
            if (arrayName.length > 0) {
                System.out.println(arrayName[0]);
            }
        }

        StringBuilder elements = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            elements.append(String.format("%.3f ", array[i]));
            if (i == array.length / 2) {
                elements.append("\n");
            }
        }
        System.out.println(elements);
    }

    private static void printElement(double[] array, int index) {
        System.out.printf("Значение ячейки по переданному индексу: %.3f%n", array[index]);
    }
}
