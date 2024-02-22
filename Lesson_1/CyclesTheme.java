public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. Подсчет суммы четных и нечетных чисел");

        int sumEven = 0;
        int sumOdd = 0;
        int currentNumber = -10;

        do {
            if (currentNumber % 2 == 0) {
                sumEven += currentNumber;
            } else {
                sumOdd += currentNumber;
            }
            currentNumber++;
        } while (currentNumber <= 21);

        System.out.println("В отрезке [-10, 21] сумма четных чисел = " + sumEven +
                ", а нечетных = " + sumOdd + "\n");

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

        for (int i = max; i >= min; i--) {
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
            System.out.printf("%2d ", i);
            numbersInString++;
        }

        for (int i = 0; i < maxNumbersPerString - numbersInString; i++) {
            System.out.printf("%2d ", 0);
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

        System.out.print("В " + someNumber);
        if (twosCount % 2 == 0) {
            System.out.print(" четное ");
        } else {
            System.out.print(" нечетное ");
        }
        System.out.print("количество двоек - " + twosCount + "\n\n");
    }
}