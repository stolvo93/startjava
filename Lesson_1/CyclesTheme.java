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

        int numbersInString = 0;
        int maxNumbersPerString = 5;

        for (int i = 1; i < 24; i++) {
            if (i % 2 != 0) {
                if (numbersInString == maxNumbersPerString) {
                    System.out.println("");
                    numbersInString = 0;
                }
                System.out.printf("%2d ", i);
                numbersInString++;
                //пропускаем итерацию, в которой i снова стало бы четным
                i++;
            } else {
                continue;
            }
        }

        for (int i = 0; i < maxNumbersPerString - numbersInString; i++) {
            System.out.printf("%2d ", 0);
        }

        System.out.println("\n\n5. Проверка количества двоек числа на четность/нечетность");


    }
}