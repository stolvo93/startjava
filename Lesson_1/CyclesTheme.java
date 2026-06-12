import java.util.Random;

class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("\n1. ВЫВОД ASCII-символов\n");

        System.out.printf("%-10s%-12s%s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");

        String rowFormat = "%4d\t%7c\t\t   %-25s%n";

        for (char character = 33; character <= 'z'; character += 2) {
            if (character == 49) character = 98;
            System.out.printf(rowFormat, (int) character, character, Character.getName(character));
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
                System.out.printf("%3d", currentNum < rangeEnd ? currentNum : 0);
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

        originalNumber = 101_002;
        int leftHalf = originalNumber / 1000;
        int rightHalf = originalNumber % 1000;
        int leftHalfSum = 0;
        int rightHalfSum = 0;

        for (int i = 1; i <= 100; i *= 10) {
            leftHalfSum += leftHalf / i % 10;
            rightHalfSum += rightHalf / i % 10;
        }

        String isLuckyNumber = leftHalfSum == rightHalfSum ? "счастливое" : "не счастливое";

        System.out.printf("""
                %,d - %s число
                Сумма цифр %03d = %d
                Сумма цифр %d = %d
                """, originalNumber, isLuckyNumber, rightHalf, rightHalfSum, leftHalf, leftHalfSum);

        System.out.println("\n8. ПРОСТОЙ ГЕНЕРАТОР ПАРОЛЯ\n");

        StringBuilder password = new StringBuilder(8);
        boolean hasSmallLetters = false;
        boolean hasCapitalLetters = false;
        boolean hasDigits = false;
        boolean hasSpecialCharacters = false;
        Random r = new Random();

        for (int i = 0; i < 8; i++) {
            char currentCharacter = (char) r.nextInt(33, 127);
            password.append(currentCharacter);
            
            if (!Character.isLetterOrDigit(currentCharacter)) {
                hasSpecialCharacters = true;
            } else if (Character.isUpperCase(currentCharacter)) {
                hasCapitalLetters = true;
            } else if (Character.isLowerCase(currentCharacter)) {
                hasSmallLetters = true; 
            } else {
                hasDigits = true;
            }
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