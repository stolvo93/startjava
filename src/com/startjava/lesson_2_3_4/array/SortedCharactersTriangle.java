package com.startjava.lesson_2_3_4.array;

public class SortedCharactersTriangle {
    private static final char FIRST_RANGE_MIN = (char) 33;
    private static final char FIRST_RANGE_MAX = (char) 126;
    private static final char SECOND_RANGE_MIN = (char) 161;
    private static final char SECOND_RANGE_MAX = (char) 255;

    public static void main(String[] args) {
        print('0', '9', true);
        print('/', '!', false);
        print('A', 'J', false);
        print((char) 29, (char) 160, true);
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
        boolean isLeftBoundInFirstRange = leftBound >= FIRST_RANGE_MIN &&
                leftBound <= FIRST_RANGE_MAX;
        boolean isLeftBoundInSecondRange = leftBound >= SECOND_RANGE_MIN &&
                leftBound <= SECOND_RANGE_MAX;
        boolean isRightBoundInFirstRange = rightBound >= FIRST_RANGE_MIN &&
                rightBound <= FIRST_RANGE_MAX;
        boolean isRightBoundInSecondRange = rightBound >= SECOND_RANGE_MIN &&
                rightBound <= SECOND_RANGE_MAX;
        if (isLeftBoundInFirstRange && isRightBoundInFirstRange ||
                isLeftBoundInSecondRange && isRightBoundInSecondRange) {
            return false;
        } else return true;
    }

    private static void printOutOfRangeError(char leftBound, char rightBound) {
        System.out.printf("Ошибка: вывод диапазона символов [%d, %d] не поддерживается. " + 
                "Ваш диапазон должен принадлежать одному из двух отрезков: " +
                "[%d, %d] или [%d, %d]%n%n", (int) leftBound, (int) rightBound,
                (int) FIRST_RANGE_MIN, (int) FIRST_RANGE_MAX,
                (int) SECOND_RANGE_MIN, (int) SECOND_RANGE_MAX);
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
        char lowerCharacter = directionAsc ? rightBound : leftBound;
        int ident = rightBound - leftBound;
        StringBuilder triangle = new StringBuilder();
        char currentCharacter = upperCharacter;
        for (int line = 1; ident >= 0; line++, ident--) {
            triangle.repeat(" ", ident);
            int width = line * 2 - 1;
            triangle.repeat(currentCharacter, width);
            triangle.append("\n");
            currentCharacter += directionAsc ? 1 : -1;
        }
        System.out.println(triangle);
    }
}
