public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. Подсчет суммы четных и нечетных чисел");

        int start = -10;
        int finish = 21;
        int sumEven = 0;
        int sumOdd = 0;
        int counter = start;

        do {
            if (counter % 2 == 0) {
                sumEven += counter;
            } else {
                sumOdd += counter;
            }
            counter++;
        } while (counter <= finish);

        System.out.printf("В отрезке [%d, %d] сумма четных чисел = %d, а нечетных = %d%n%n",
                start, finish, sumEven, sumOdd);

        System.out.println("2. Вывод чисел в порядке убывания");

        int a = 10;
        int b = 5;
        int c = -1;
        int max = b;
        int min = a;

        if (a > b) {
            max = a;
            min = b;
        }

        if (c > max) {
            max = c;
        } else if (c < min) {
            min = c;
        }

        for (int i = max - 1; i > min; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр");

        int originalNumber = 1234;
        int sumDigits = 0;

        while (originalNumber > 0) {
            int digit = originalNumber % 10;
            System.out.print(digit);
            sumDigits += digit;
            originalNumber /= 10;
        }
        
        System.out.println("\n" + sumDigits + "\n");

        System.out.println("4. Вывод чисел в несколько строк");

        int startRange = 1;
        int endRange = 24;

        //необходимо начать цикл с наименьшего нечетного значения в заданном диапазоне
        if (startRange % 2 == 0) {
            startRange++;
        }

        int numbersInLine = 0;
        int maxNumbersPerLine = 5;

        //вывод всех нечетных значений в заданном диапазоне
        for (int i = startRange; i < endRange; i += 2) {
            if (numbersInLine == maxNumbersPerLine) {
                System.out.println();
                numbersInLine = 0;
            }
            System.out.printf("%3d", i);
            numbersInLine++;
        }

        for (int i = 0; i < maxNumbersPerLine - numbersInLine; i++) {
            System.out.printf("%3d", 0);
        }

        System.out.println("\n\n5. Проверка количества двоек числа на четность/нечетность");

        originalNumber = 3242592;
        int countTwos = 0;
        int originalNumberCopy = originalNumber;

        while (originalNumberCopy > 0) {
            if (originalNumberCopy % 10 == 2) {
                countTwos++;
            }
            originalNumberCopy /= 10;
        }

        System.out.printf("В %d %sчетное количество двоек - %d%n%n",
                originalNumber, countTwos % 2 == 0 ? "" : "не", countTwos);

        System.out.println("6. Отображение геометрических фигур");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();

        int stringCounter = 5;

        while (stringCounter > 0) {
            int numberSignCounter = stringCounter;
            while (numberSignCounter > 0) {
                System.out.print("#");
                numberSignCounter--;
            }
            System.out.println();
            stringCounter--;
        }
        System.out.println();

        int ascStringCounter = 1;
        int descStringCounter = 5;

        do {
            int stringLength;
            if (ascStringCounter <= 3) {
                stringLength = ascStringCounter;
            } else {
                stringLength = descStringCounter;
            }
            int dollarSignCounter = 1;

            do {
                System.out.print("$");
                dollarSignCounter++;
            } while (dollarSignCounter <= stringLength);
            ascStringCounter++;
            descStringCounter--;
            System.out.println();
        } while (ascStringCounter <= 5);

        System.out.println("\n7. Отображение ASCII-символов");

        System.out.printf("%-10S%-12S%S%n", "decimal", "character", "decription");

        for (int i = 15; i < 48; i += 2) {
            System.out.printf("%5d%10s\t\t%s%n", i, (char) i, Character.getName(i));
        }

        for (int i = 98; i < 123; i += 2) {
            System.out.printf("%5d%10s\t\t%s%n", i, (char) i, Character.getName(i));
        }

        System.out.println("\n8. Проверка, является ли число палиндромом");

        originalNumber = 1234321;
        originalNumberCopy = originalNumber;
        int reversedNumber = 0;

        while (originalNumberCopy > 0) {
            reversedNumber *= 10;
            reversedNumber += originalNumberCopy % 10;
            originalNumberCopy /= 10;
        }

        System.out.printf("Число %d%s является палиндромом%n%n", originalNumber,
                reversedNumber == originalNumber ? "" : " не");

        System.out.println("9. Проверка, является ли число счастливым");

        int happyNumber = 123124;
        int leftHalf = 0;
        int rightHalf = 0;
        int sumLeftHalf = 0;
        int sumRightHalf = 0;
        counter = 1;

        for (int i = 0; i < 6; i++) {
            int digit = happyNumber % 10;
            if (counter <= 100) {
                rightHalf += digit * counter;
                sumRightHalf += digit;
            } else {
                leftHalf += digit * counter / 1000;
                sumLeftHalf += digit;
            }
            counter *= 10;
            happyNumber /= 10;
        }

        System.out.printf("Число %d%d%s является счастливым%n", leftHalf, rightHalf,
                sumLeftHalf == sumRightHalf ? "" : " не");
        System.out.printf("Сумма цифр %d = %d, а сумма %d = %d%n%n", leftHalf, sumLeftHalf, rightHalf, sumRightHalf);

        System.out.println("10. Отображение таблицы умножения Пифагора");

        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if (i > 1 & j > 1) {
                    System.out.printf("%3d", i * j);
                } else if (i != 1 & j == 1) {
                    System.out.print("|");
                } else if (i == 1 & j != 1) {
                    System.out.print("---");
                } else if (i != 0 & j == 0) {
                    System.out.printf("%2d ", i);
                } else if (i == 0 & j != 0) {
                    System.out.printf("%3d", j);
                } else if (i == 1 & j == 1) {
                    System.out.print("+");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}