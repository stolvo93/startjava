public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("1. Перевод псевдокода на язык Java");

        boolean isMale = true;

        if (!isMale) {
            System.out.println("Pronouns: she/her/hers/herself");
        } else {
            System.out.println("Pronouns: he/him/his/himself");
        }

        int age = 15;

        if (age > 18) {
            System.out.println("Доступ разрешён");
        } else {
            System.out.println("Доступ несовершеннолетним запрещён!");
        }

        double height = 1.8;

        if (height < 1.8) {
            System.out.println("Я сегодня занята");
        } else {
            System.out.println("Да, давай сходим куда-нибудь");
        }

        char firstLetterOfName = "Anna".charAt(0);

        if (firstLetterOfName == 'М') {
            System.out.println("Ваше имя \"Мария\"?");
        } else if (firstLetterOfName == 'I') {
            System.out.println("Ваше имя \"Ирина?\"");
        } else {
            System.out.println("Ваше имя точно не \"Мария\" и не \"Ирина\"\n");
        }

        System.out.println("2. Поиск большего числа");

        int num1 = 80;
        int num2 = -298;

        if (num1 > num2) {
            System.out.println(num1 + " > " + num2 + "\n");
        } else if (num1 < num2) {
            System.out.println(num1 + " < " + num2 + "\n");
        } else {
            System.out.println(num1 + " = " + num2 + "\n");
        }

        System.out.println("3. Проверка числа");

        int num3 = 121;

        if (num3 == 0) {
            System.out.println("Заданное число является нулём\n");
        } else {
            if (num3 > 0) {
                System.out.print(num3 + " является положительным");
            } else {
                System.out.print(num3 + " является отрицательным");
            }
            if (num3 % 2 == 0) {
                System.out.println(" и чётным\n");
            } else {
                System.out.println(" и нечётным\n");
            }
        }

        System.out.println("4. Поиск одинаковых цифр в числах");

        int num4 = -518;
        int num5 = 598;

        //вычисление абсолютных значений переменных
        int absNum4 = num4 < 0 ? -num4 : num4;
        int absNum5 = num5 < 0 ? -num5 : num5;

        //вычисление разрядов обоих чисел
        int num4Ones = absNum4 % 10;
        int num5Ones = absNum5 % 10;
        int num4Tens = absNum4 / 10 % 10;
        int num5Tens = absNum5 / 10 % 10;
        int num4Hundreds = absNum4 / 100;
        int num5Hundreds = absNum5 / 100;

        //вывод сообщений в зависимости от наличия одинаковых разрядов
        if (!(num4Ones == num5Ones |
                num4Tens == num5Tens | 
                num4Hundreds == num5Hundreds)) {
            System.out.println("Числа " + num4 + " и " + num5 + " не имеют одинаковых разрядов");
        } else {
            System.out.println("Числа " + num4 + " и " + num5 + " имеют следующие одинаковые разряды:");
            if (num4Ones == num5Ones) {
                System.out.println("разряд 1: " + num4Ones);
            }
            if (num4Tens == num5Tens) {
                System.out.println("разряд 2: " + num4Tens);
            }
            if (num4Hundreds == num5Hundreds) {
                System.out.println("разряд 3: " + num4Hundreds);
            }
        }

        System.out.println("\n5. Определение символа по его коду");

        char someChar = '\u0057';

        if (someChar >= 'A' & someChar <= 'Z') {
            System.out.println("Символ " + someChar + " является большой буквой\n");
        } else if (someChar >= 'a' & someChar <= 'z') {
            System.out.println("Символ " + someChar + " является маленькой буквой\n");
        } else if (someChar >= '0' & someChar <= '9') {
            System.out.println("Символ " + someChar + " является цифрой\n");
        } else {
            System.out.println("Символ " + someChar + " не является буквой или цифрой\n");
        }

        System.out.println("6. Подсчет суммы вклада и начисленных банком %");

        double depositSum = 301_000;
        double depositInterestRate = 0.1;

        if (depositSum < 100_000) {
            depositInterestRate = 0.05;
        } else if (depositSum <= 300_000) {
            depositInterestRate = 0.07;
        }

        System.out.println("Сумма вклада: " + depositSum);
        System.out.println("Сумма начисленного %: " + depositSum * depositInterestRate);
        System.out.println("Итоговая сумма с %: " + depositSum * (1 + depositInterestRate) + "\n");

        System.out.println("7. Определение оценки по предметам");

        //определение оценки по истории
        int scoreHistory = 59;
        int gradeHistory;
        if (scoreHistory <= 60) {
            gradeHistory = 2;
        } else if (scoreHistory <= 73) {
            gradeHistory = 3;
        } else if (scoreHistory <= 91) {
            gradeHistory = 4;
        } else {
            gradeHistory = 5;
        }

        //определение оценки по программированию
        int scoreProgramming = 92;
        int gradeProgramming;
        if (scoreProgramming <= 60) {
            gradeProgramming = 2;
        } else if (scoreProgramming <= 73) {
            gradeProgramming = 3;
        } else if (scoreProgramming <= 91) {
            gradeProgramming = 4;
        } else {
            gradeProgramming = 5;
        }

        System.out.println("Оценка по истории - " + gradeHistory);
        System.out.println("Оценка по программированию - " + gradeProgramming);
        System.out.println("Средний балл оценок по предметам - " +
                (double) (gradeHistory + gradeProgramming) / 2);
        System.out.println("Средний % по предметам - " +
                (double) (scoreHistory + scoreProgramming) / 2 + "\n");

        System.out.println("8. Расчет годовой прибыли");

        int sales = 13000;
        int roomRental = 5000;
        int productionCosts = 9000;
        int annualProfit = (sales - roomRental - productionCosts) * 12;

        System.out.print("Прибыль за год: ");
        if (annualProfit > 0) {
            System.out.print("+");
        }
        System.out.println(annualProfit + " руб.\n");
    }
}