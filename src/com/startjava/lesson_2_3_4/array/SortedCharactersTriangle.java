package com.startjava.lesson_2_3_4.array;

public class SortedCharactersTriangle {
    private static final char VISIBLE_ASCII_MIN = 33; // '!'
    private static final char VISIBLE_ASCII_MAX = 126; // '~'
    private static final char VISIBLE_EXTENDED_MIN = 161; // '¡'
    private static final char VISIBLE_EXTENDED_MAX = 255; // 'ÿ'

    public static void main(String[] args) {
        print('0', '9', true);
        print('/', '!', false);
        print('A', 'J', false);
        print((char) 29, (char) 160, true);
        print((char) 225, (char) 235, true);
    }

    private static void print(char leftBound, char rightBound, boolean directionAsc) {
        if (isUnsupportedRange(leftBound, rightBound)) {
            printUnsupportedRangeError(leftBound, rightBound);
            return;
        }
        if (leftBound > rightBound) {
            printWrongOrderError(leftBound, rightBound);
            return;
        }
        printTriangle(leftBound, rightBound, directionAsc);
    }

    private static boolean isUnsupportedRange(char leftBound, char rightBound) {
        boolean isBothBoundsInVisibleAscii = isBothBoundsInRange(leftBound, rightBound,
                VISIBLE_ASCII_MIN, VISIBLE_ASCII_MAX);
        boolean isBothBoundsInVisibleExtended = isBothBoundsInRange(leftBound, rightBound,
                VISIBLE_EXTENDED_MIN, VISIBLE_EXTENDED_MAX);
        return !(isBothBoundsInVisibleAscii || isBothBoundsInVisibleExtended);
    }

    private static boolean isBothBoundsInRange(char leftBound, char rightBound, char min, char max) {
        boolean leftBoundInRange = leftBound >= min && leftBound <= max;
        boolean rightBoundInRange = rightBound >= min && rightBound <= max;
        return leftBoundInRange && rightBoundInRange;
    }

    private static void printUnsupportedRangeError(char leftBound, char rightBound) {
        System.out.printf("""
                Ошибка: вывод диапазона символов [%d, %d] не поддерживается.
                Ваш диапазон должен принадлежать одному из двух отрезков: [%d, %d] или [%d, %d]%n%n""",
                (int) leftBound, (int) rightBound,
                (int) VISIBLE_ASCII_MIN, (int) VISIBLE_ASCII_MAX,
                (int) VISIBLE_EXTENDED_MIN, (int) VISIBLE_EXTENDED_MAX);
    }

    private static void printWrongOrderError(char leftBound, char rightBound) {
        System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n%n",
                (int) leftBound, (int) rightBound);
    }

    private static void printTriangle(char leftBound, char rightBound, boolean directionAsc) {
        int indent = rightBound - leftBound;
        char currentCharacter = directionAsc ? leftBound : rightBound;
        StringBuilder triangle = new StringBuilder();
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