import java.math.BigDecimal;
import java.math.RoundingMode;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("\n1. ПЕРЕВОД ПСЕВДОКОДА НА ЯЗЫК JAVA\n");

        boolean male = true;
        int age = 12;
        float height = 1.7f;
        if (!male) {
            System.out.println("Пол: женский");
        } else {
            System.out.println("Пол: мужской");
        }

        if (age > 18) {
            System.out.println("Совершеннолетний");
        } else {
            System.out.println("Несовершеннолетний");
        }

        if (height < 1.8) {
            System.out.println("Доступные секции: спортивная гимнастика, фигурное катание");
        } else {
            System.out.println("Доступные секции: баскетбол, волейбол, плавание, теннис");
        }

        System.out.println("\n2. ПОИСК БОЛЬШЕГО ЧИСЛА ШАГОВ\n");

        int yesterdaySteps = 12345;
        int todaySteps = 7654;

        System.out.println("Шагов вчера: " + yesterdaySteps);
        System.out.println("Шагов сегодня: " + todaySteps);

        if (todaySteps > yesterdaySteps) {
            System.out.println("Сегодня пройдено больше шагов, чем вчера");
        } else if (todaySteps < yesterdaySteps) {
            System.out.println("Вчера пройдено больше шагов, чем сегодня");
        } else {
            System.out.println("Сегодня пройдено столько же шагов, сколько и вчера");
        }

        double avgSteps = ((double) yesterdaySteps + todaySteps) / 2;

        System.out.println("Среднее количество шагов: " + avgSteps);

        System.out.println("\n3. ПРОВЕРКА КОЛИЧЕСТВА ГОСТЕЙ\n");

        int guestsNumber = 12;

        if (guestsNumber == 0) {
            System.out.println("Пока никто не записался на мероприятие!");
        } else if (guestsNumber < 0) {
            System.out.println("ОШИБКА: количество гостей не может быть отрицательным!");
        } else if ((guestsNumber % 2) == 0) {
            System.out.printf("Записалось %d гостей. Можно формировать пары для конкурсов.\n", guestsNumber);
        } else {
            System.out.printf("Записалось %d гостей. Нужны индивидуальные задания.\n", guestsNumber);
        }

        System.out.println("\n4. ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА\n");

        String nickname = "µъыъыъ";
        char firstChar = nickname.charAt(0);

        if (Character.isLowerCase(firstChar)) {
            System.out.printf("Имя %s начинается с маленькой буквы '%c'\n", nickname, firstChar);
        } else if (Character.isUpperCase(firstChar)) {
            System.out.printf("Имя %s начинается с большой буквы '%c'\n", nickname, firstChar);
        } else if (Character.isDigit(firstChar)) {
            System.out.printf("Имя %s начинается с цифры '%c'\n", nickname, firstChar);
        } else {
            System.out.printf("Имя %s начинается с символа '%c'\n", nickname, firstChar);
        }

        System.out.println("\n5. ИНВЕНТАРИЗАЦИЯ\n");

        int dbSerialNumber = 785;
        int pcSerialNumber = 965;

        if (pcSerialNumber == dbSerialNumber) {
            System.out.printf("[№%d]: компьютер на 3-м этаже в кабинете 2\n", pcSerialNumber);
        } else {
            int hundreds = pcSerialNumber / 100;
            char hundredsChar = (char) ('0' + hundreds);
            hundredsChar = (hundreds == (dbSerialNumber / 100)) ? hundredsChar : '_';

            int tens = pcSerialNumber / 10 % 10;
            char tensChar = (char) ('0' + tens);
            tensChar = (tens == (dbSerialNumber / 10 % 10)) ? tensChar : '_';

            int ones = pcSerialNumber % 10;
            char onesChar = (char) ('0' + ones);
            onesChar = (ones == (dbSerialNumber % 10)) ? onesChar : '_';
            
            if (hundredsChar == '_' && tensChar == '_' && onesChar == '_') {
                System.out.printf("[№%d]: оборудование не идентифицировано\n", pcSerialNumber);
            } else {
                System.out.printf("""
                        Нет полного совпадения:
                        База данных: [№%d]
                        Фактический: [№%c%c%c]
                        \n""", dbSerialNumber, hundredsChar, tensChar, onesChar);
            }
        }

        System.out.println("\n6. ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ %\n");

        System.out.println("ПЕРВЫЙ СПОСОБ:");

        float deposit = 321_123.7900000f;

        System.out.printf("Сумма вклада: %,f\n", deposit);

        float interestRate = 0.1f;

        if (deposit < 100_000) {
            interestRate = 0.05f;
        } else if (deposit <= 300_000) {
            interestRate = 0.07f;
        }

        System.out.printf("Сумма начисленного %%: %,f\n", deposit * interestRate);
        System.out.printf("Итоговая сумма с %%: %,f\n", deposit * (1 + interestRate));

        System.out.println("\nВТОРОЙ СПОСОБ:");

        BigDecimal depositBd = new BigDecimal("321123.79");

        System.out.printf("Сумма вклада: %s\n", depositBd);

        BigDecimal interestRateBd = new BigDecimal("0.1");

        if (depositBd.compareTo(new BigDecimal("100000")) < 0) {
            interestRateBd = new BigDecimal("0.05");
        } else if (depositBd.compareTo(new BigDecimal("300000")) <= 0) {
            interestRateBd = new BigDecimal("0.07");
        }

        BigDecimal interestAmountBd = depositBd.multiply(interestRateBd).setScale(2, RoundingMode.HALF_UP);

        System.out.printf("Сумма начисленного %%: %s\n", interestAmountBd);
        System.out.printf("Итоговая сумма с %%: %s\n", depositBd.add(interestAmountBd)
                .setScale(2, RoundingMode.HALF_UP));
    }
}