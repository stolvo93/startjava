package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class SortedCharactersTriangle {
    public static void main(String[] args) {
        Random random = new Random();
        int leftBoundary = random.nextInt(33, 127);
        int rightBoundary = random.nextInt(33, 127);
        boolean isDirectionAsc = true;
        printSortedTriangle(52, 60, isDirectionAsc);
    }

    private static void printSortedTriangle(int leftBoundary, int rightBoundary,
                                            boolean isDirectionAsc) {
        char upperCharacter = isDirectionAsc ? (char) leftBoundary : (char) rightBoundary;
        char lowerCharacter = isDirectionAsc ? (char) rightBoundary : (char) leftBoundary;
        int height = rightBoundary - leftBoundary + 1;
        int ident = height - 1;
        StringBuilder triangle = new StringBuilder();
        for (char ch = upperCharacter; ch <= lowerCharacter; ch++, ident--) {
            triangle.repeat(" ", ident);
            int width = (height - ident) * 2 - 1;
            triangle.repeat(ch, width);
            triangle.append("\n");
        }
        System.out.println(triangle);
    }
}
