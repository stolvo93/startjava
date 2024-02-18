public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("1. Перевод псевдокода на язык Java");

        boolean isMale = true;

        if (!isMale) {
            System.out.println("Pronouns: he/him/his/himself");
        } else {
            System.out.println("Pronouns: she/her/hers/herself");
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
        int num4OnesDigit = absNum4 % 10;
        int num5OnesDigit = absNum5 % 10;
        int num4TensDigit = absNum4 / 10 % 10;
        int num5TensDigit = absNum5 / 10 % 10;
        int num4HundredsDigit = absNum4 / 100;
        int num5HundredsDigit = absNum5 / 100;

        //вывод сообщений в зависимости от наличия одинаковых разрядов
        if (!(num4OnesDigit == num5OnesDigit |
                num4TensDigit == num5TensDigit | 
                num4HundredsDigit == num5HundredsDigit)) {
            System.out.println("Числа " + num4 + " и " + num5 + " не имеют одинаковых разрядов");
        } else {
            System.out.println("Числа " + num4 + " и " + num5 + " имеют следующие одинаковые разряды:");
            if (num4OnesDigit == num5OnesDigit) {
                System.out.println("разряд 1: " + num4OnesDigit);
            }
            if (num4TensDigit == num5TensDigit) {
                System.out.println("разряд 2: " + num4TensDigit);
            }
            if (num4HundredsDigit == num5HundredsDigit) {
                System.out.println("разряд 3: " + num4HundredsDigit);
            }
        }

        System.out.println("\n5. Определение символа по его коду");

        char charVariable = '\u0057';

        if (charVariable >= 'A' & charVariable <= 'Z') {
            System.out.println("Символ " + charVariable + " является большой буквой\n");
        } else if (charVariable >= 'a' & charVariable <= 'z') {
            System.out.println("Символ " + charVariable + " является маленькой буквой\n");
        } else if (charVariable >= '0' & charVariable <= '9') {
            System.out.println("Символ " + charVariable + " является цифрой\n");
        } else {
            System.out.println("Символ " + charVariable + " не является буквой или цифрой\n");
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
    }
}