package com.startjava.lesson_2_3_4.array;

public class SortedCharactersTriangle {
    private static final char RANGE_1_MIN = (char) 33;
    private static final char RANGE_1_MAX = (char) 126;
    private static final char RANGE_2_MIN = (char) 161;
    private static final char RANGE_2_MAX = (char) 255;

    public static void main(String[] args) {
        print('0', '9', true);
        print('/', '!', false);
        print('A', 'J', false);
        print((char) 29, (char) 160, true);
        print((char) 178, (char) 204, true);
    }

    private static void print(char leftBound, char rightBound, boolean directionAsc) {
        if (isOutOfRange(leftBound, rightBound)) {
            printOutOfRangeError(leftBound, rightBound);
            return;
        }
        if (isWrongOrder(leftBound, rightBound)) {
            printWrongOrderError(leftBound, rightBound);
            return;
        }
        printTriangle(leftBound, rightBound, directionAsc);
    }

    private static boolean isOutOfRange(char leftBound, char rightBound) {
        boolean isBothBoundsInRange1 = isBothBoundsInRange(leftBound, rightBound, RANGE_1_MIN, RANGE_1_MAX);
        boolean isBothBoundsInRange2 = isBothBoundsInRange(leftBound, rightBound, RANGE_2_MIN, RANGE_2_MAX);
        return !(isBothBoundsInRange1 || isBothBoundsInRange2);
    }

    private static boolean isBothBoundsInRange(char bound1, char bound2, char min, char max) {
        boolean bound1InRange = bound1 >= min && bound1 <= max;
        boolean bound2InRange = bound2 >= min && bound2 <= max;
        return bound1InRange && bound2InRange;
    }

    private static void printOutOfRangeError(char leftBound, char rightBound) {
        System.out.printf("Ошибка: вывод диапазона символов [%d, %d] не поддерживается. " + 
                "Ваш диапазон должен принадлежать одному из двух отрезков: " +
                "[%d, %d] или [%d, %d]%n%n", (int) leftBound, (int) rightBound,
                (int) RANGE_1_MIN, (int) RANGE_1_MAX,
                (int) RANGE_2_MIN, (int) RANGE_2_MAX);
    }

    private static boolean isWrongOrder(char leftBound, char rightBound) {
        return leftBound > rightBound;
    }

    private static void printWrongOrderError(char leftBound, char rightBound) {
        System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n%n",
                (int) leftBound, (int) rightBound);
    }

    private static void printTriangle(char leftBound, char rightBound, boolean directionAsc) {
        char upperCharacter = directionAsc ? leftBound : rightBound;
        int indent = rightBound - leftBound;
        StringBuilder triangle = new StringBuilder();
        char currentCharacter = upperCharacter;
        for (int line = 1; indent >= 0; line++, indent--) {
            triangle.repeat(" ", indent);
            int width = line * 2 - 1;
            triangle.repeat(currentCharacter, width);
            triangle.append("\n");
            if (directionAsc) currentCharacter++;
            else currentCharacter--;
        }
        System.out.println(triangle);
    }
}
