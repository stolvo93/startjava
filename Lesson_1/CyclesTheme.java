public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. Подсчет суммы четных и нечетных чисел");

        int initialNumber = -10;
        int finalNumber = 21;
        int sumEven = 0;
        int sumOdd = 0;
        int currentNumber = initialNumber;

        do {
            if (currentNumber % 2 == 0) {
                sumEven += currentNumber;
            } else {
                sumOdd += currentNumber;
            }
            currentNumber++;
        } while (currentNumber <= finalNumber);

        System.out.printf("В отрезке [%d, %d] сумма четных чисел = %d, а нечетных = %d%n%n",
                initialNumber, finalNumber, sumEven, sumOdd);

        System.out.println("2. Вывод чисел в порядке убывания");

        int number1 = 10;
        int number2 = 5;
        int number3 = -1;
        int max = 0;
        int min = 0;

        if (number1 >= number2 & number1 >= number3) {
            max = number1;
        } else if (number2 >= number3) {
            max = number2;
        } else {
            max = number3;
        }

        if (number1 <= number2 & number1 <= number3) {
            min = number1;
        } else if (number2 <= number3) {
            min = number2;
        } else {
            min = number3;
        }

        for (int i = max - 1; i > min; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр");

        int originalNumber = 1234;
        int anotherDigit;
        int sumDigits = 0;

        while (originalNumber != 0) {
            anotherDigit = originalNumber % 10;
            System.out.print(anotherDigit);
            sumDigits += anotherDigit;
            originalNumber /= 10;
        }
        
        System.out.println("\n" + sumDigits + "\n");

        System.out.println("4. Вывод чисел в несколько строк");

        int startOfRange = 1;
        int endOfRange = 24;

        //необходимо начать цикл с наименьшего нечетного значения в заданном диапазоне
        if (startOfRange % 2 == 0) {
            startOfRange++;
        }

        int numbersInString = 0;
        int maxNumbersPerString = 5;

        //вывод всех нечетных значений в заданном диапазоне
        for (int i = startOfRange; i < endOfRange; i += 2) {
            if (numbersInString == maxNumbersPerString) {
                System.out.println("");
                numbersInString = 0;
            }
            System.out.printf("%3d", i);
            numbersInString++;
        }

        for (int i = 0; i < maxNumbersPerString - numbersInString; i++) {
            System.out.printf("%3d", 0);
        }

        System.out.println("\n\n5. Проверка количества двоек числа на четность/нечетность");

        int someNumber = 3242592;
        int twosCount = 0;
        int calculationNumber = someNumber;

        while (calculationNumber != 0) {
            if (calculationNumber % 10 == 2) {
                twosCount++;
            }
            calculationNumber /= 10;
        }

        System.out.printf("В %d %sчетное количество двоек - %d%n%n",
                someNumber, twosCount % 2 == 0 ? "" : "не", twosCount);

        System.out.println("6. Отображение геометрических фигур");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        System.out.println("");

        int stringCounter = 5;

        while (stringCounter != 0) {
            int numberSignCounter = stringCounter;
            while (numberSignCounter != 0) {
                System.out.print("#");
                numberSignCounter--;
            }
            System.out.println("");
            stringCounter--;
        }
        System.out.println("");

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
            System.out.println("");
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

        int checkedNumber = 1234321;
        int temporaryNumber = checkedNumber;
        int reversedNumber = 0;

        while (temporaryNumber != 0) {
            reversedNumber *= 10;
            reversedNumber += temporaryNumber % 10;
            temporaryNumber /= 10;
        }

        System.out.printf("Число %d%s является палиндромом%n%n", checkedNumber,
                reversedNumber == checkedNumber ? "" : " не");

        System.out.println("9. Проверка, является ли число счастливым");

        int happyNumber = 123124;
        int tmp;
        int digitsDef = 0;
        int sumDef = 0;

        for (int i = 1; i <= 3; i++) {
            tmp = happyNumber % 10;
            sumDef += tmp;
            for (int j = 1; j < i; j++) {
                tmp *= 10;
            }
            digitsDef += tmp;
            happyNumber /= 10;
        }

        int sumAbc = 0;
        int digitsAbc = 0;

        for (int i = 0; i <= 3; i++) {
            tmp = happyNumber % 10;
            sumAbc += tmp;
            for (int j = 1; j <= i; j++) {
                tmp *= 10;
            }
            digitsAbc += tmp;
            happyNumber /= 10;
        }

        System.out.printf("Число %d%d%s является счастливым%n", digitsAbc, digitsDef,
                sumAbc == sumDef ? "" : " не");
        System.out.printf("Сумма цифр %d = %d, а сумма %d = %d%n%n", digitsAbc, sumAbc, digitsDef, sumDef);

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
            System.out.println("");
        }
    }
}