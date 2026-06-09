import java.util.Random;

class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("\n1. ВЫВОД ASCII-символов\n");

        System.out.printf("%-10s%-12s%s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");

        String rowFormat = "%4d\t%7c\t\t   %-25s%n";
        char character = 33;

        while (character <= 'z') {
            if (character % 2 != 0 && character < '0' ||
                    character % 2 == 0 && character >= 'a') {
                System.out.printf(rowFormat, (int) character, character, Character.getName(character));
            }
            character++;
        }

        System.out.println("\n2. ВЫВОД ГЕОМЕТРИЧЕСКИХ ФИГУР\n");

        int height = 5;
        int width = height * 4 + 2;

        for (int i = 0; i < height; i++) {
            for (int j = 1; j <= width; j++) {
                if (j == width / 2 ||
                        (j == width / 2 + height - i + 1)) {
                    System.out.print(' ');
                } else if (j < width / 2) {
                    System.out.print('-');
                } else if (j <= (width / 2 + height - i)) {
                    System.out.print('*');
                } else if (j <= (width / 2 + height + i + 2)) {
                    System.out.print('^');
                }
            }
            System.out.println();
        }

        System.out.println("\n3. ВЫВОД ТАБЛИЦЫ УМНОЖЕНИЯ\n");
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("   ");
                } else if (i == 1 && j == 1) {
                    System.out.print('+');
                } else if (j == 1) {
                    System.out.print('|');
                } else if (i == 1) {
                    System.out.print("---");
                } else if (i == 0) {
                    System.out.printf("%3d", j);
                } else if (j == 0) {
                    System.out.printf(" %-2d", i);
                } else System.out.printf("%3d", i * j);
            }
            System.out.println();
        }

        System.out.println("\n4. ВЫВОД ЧИСЕЛ В НЕСКОЛЬКО СТРОК\n");

        int rangeStart = 1;
        int rangeEnd = 24;
        int currentNum = rangeStart;

        if (currentNum % 2 == 0) currentNum++;

        while (currentNum < rangeEnd) {
            for (int i = 0; i < 5; i++) {
                if (currentNum < rangeEnd) {
                    System.out.printf("%3d", currentNum);
                } else {
                    System.out.printf("%3d", 0);
                }
                currentNum += 2;
            }
            System.out.println();
        }

        System.out.println("\n5. ВЫВОД ЧИСЕЛ МЕЖДУ MIN И MAX\n");

        int num1 = 10;
        int num2 = 5;
        int num3 = -1;

        int max = num1 > num2 ? num1 : num2;
        max = num3 > max ? num3 : max;
        
        int min = num1 < num2 ? num1 : num2;
        min = num3 < min ? num3 : min;

        for (int i = max - 1; i > min; i--) {
            System.out.printf("%-3d", i);
        }

        System.out.println("\n\n6. РАЗНЫЕ ОПЕРАЦИИ НАД ЧИСЛОМ\n");

        int originalNumber = 2234321;
        int reversedNumber = 0;
        int tmpNumber = originalNumber;
        int twosCount = 0;

        while (tmpNumber > 0) {
            if (tmpNumber % 10 == 2) {
                twosCount++;
            }
            reversedNumber = reversedNumber * 10 + tmpNumber % 10;
            tmpNumber /= 10;
        }
        
        String isPalindrome = reversedNumber == originalNumber ? "палиндром" : "не палиндром";
        String hasEvenTwosCount = twosCount % 2 == 0 ? "четным" : "нечетным";

        System.out.printf("%d - %s с %s (%d) количеством двоек%n",
                originalNumber, isPalindrome, hasEvenTwosCount, twosCount);

        System.out.println("\n7. ПРОВЕРКА СЧАСТЛИВОГО ЧИСЛА\n");

        int initialNumber = 101002;
        int leftDigits = initialNumber / 1000;
        int rightDigits = initialNumber % 1000;
        int leftDigitsSum = 0;

        tmpNumber = leftDigits;

        while (tmpNumber > 0) {
            leftDigitsSum += tmpNumber % 10;
            tmpNumber /= 10;
        }

        int rightDigitsSum = 0;

        tmpNumber = rightDigits;

        while (tmpNumber > 0) {
            rightDigitsSum += tmpNumber % 10;
            tmpNumber /= 10;
        }

        String isLuckyNumber = leftDigitsSum == rightDigitsSum ? "счастливое" : "не счастливое";

        System.out.printf("""
                %d - %s число
                Сумма цифр %03d = %d
                Сумма цифр %d = %d
                """, initialNumber, isLuckyNumber, rightDigits, rightDigitsSum, leftDigits, leftDigitsSum);

        System.out.println("\n8. ПРОСТОЙ ГЕНЕРАТОР ПАРОЛЯ\n");

        String password = "";
        boolean hasSmallLetters = false;
        boolean hasCapitalLetters = false;
        boolean hasDigits = false;
        boolean hasSpecialCharacters = false;
        char nextCharacter;
        Random r = new Random();

        for (int i = 0; i < 8; i++) {
            nextCharacter = (char) r.nextInt(33, 126);
            password += nextCharacter;
            if (nextCharacter >= 'a' && nextCharacter <= 'z') {
                hasSmallLetters = true;
            } else if (nextCharacter >= 'A' && nextCharacter <= 'Z') {
                hasCapitalLetters = true;
            } else if (nextCharacter >= '0' && nextCharacter <= '9') {
                hasDigits = true;
            } else hasSpecialCharacters = true;
        }

        String passwordStrength = "Слабый";

        if (password.length() >= 8 && hasSmallLetters && hasCapitalLetters && hasSpecialCharacters) {
            passwordStrength = "Надёжный";
        } else if (password.length() >= 8 && (hasCapitalLetters || hasDigits)) {
            passwordStrength = "Средний";
        }

        System.out.println("Пароль: " + password);
        System.out.println("Надёжность: " + passwordStrength);
    }
}