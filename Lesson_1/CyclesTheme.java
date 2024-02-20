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

        int num1 = 10;
        int num2 = 5;
        int num3 = -1;
        int max = 0;
        int min = 0;

        if (num1 >= num2 & num1 >= num3) {
            max = num1;
        } else if (num2 >= num3) {
            max = num2;
        } else {
            max = num3;
        }

        if (num1 <= num2 & num1 <= num3) {
            min = num1;
        } else if (num2 <= num3) {
            min = num2;
        } else {
            min = num3;
        }

        for (int i = max; i >= min; i--) {
            System.out.print(i + " ");
        }
    }
}