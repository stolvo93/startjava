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
            System.out.printf("Записалось %d гостей. Можно формировать пары для конкурсов.%n", guestsNumber);
        } else {
            System.out.printf("Записалось %d гостей. Нужны индивидуальные задания.%n", guestsNumber);
        }

        System.out.println("\n4. ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА\n");

        String nickname = "µъыъыъ";
        String messageStart = String.format("Имя %s начинается с ", nickname);
        String messageEnd = "символа '%c'%n";
        char firstChar = nickname.charAt(0);

        System.out.println("ПЕРВЫЙ СПОСОБ:");

        if (firstChar >= 'a' && firstChar <= 'z' || firstChar >= 'а' && firstChar <= 'я') {
            messageEnd = "маленькой буквы '%c'%n";
        } else if (firstChar >= 'A' && firstChar <= 'Z' || firstChar >= 'А' && firstChar <= 'Я') {
            messageEnd = "большой буквы '%c'%n";
        } else if (firstChar >= '0' && firstChar <= '9') {
            messageEnd = "цифры '%c'%n";
        }

        System.out.printf(messageStart + messageEnd, firstChar);

        System.out.println("\nВТОРОЙ СПОСОБ:");

        if (Character.isLowerCase(firstChar)) {
            messageEnd = "маленькой буквы '%c'%n";
        } else if (Character.isUpperCase(firstChar)) {
            messageEnd = "большой буквы '%c'%n";
        } else if (Character.isDigit(firstChar)) {
            messageEnd = "цифры '%c'%n";
        } else {
            messageEnd = "символа '%c'%n";
        }

        System.out.printf(messageStart + messageEnd, firstChar);

        System.out.println("\n5. ИНВЕНТАРИЗАЦИЯ\n");

        int dbSerialNumber = 785;
        int itemSerialNumber = 965;

        if (itemSerialNumber == dbSerialNumber) {
            System.out.printf("[№%d]: компьютер на 3-м этаже в кабинете 2%n", itemSerialNumber);
        } else {
            int hundreds = itemSerialNumber / 100;
            char hundredsChar = (char) ('0' + hundreds);
            hundredsChar = (hundreds == (dbSerialNumber / 100)) ? hundredsChar : '_';

            int tens = itemSerialNumber / 10 % 10;
            char tensChar = (char) ('0' + tens);
            tensChar = (tens == (dbSerialNumber / 10 % 10)) ? tensChar : '_';

            int ones = itemSerialNumber % 10;
            char onesChar = (char) ('0' + ones);
            onesChar = (ones == (dbSerialNumber % 10)) ? onesChar : '_';
            
            if (hundredsChar == '_' && tensChar == '_' && onesChar == '_') {
                System.out.printf("[№%d]: оборудование не идентифицировано", itemSerialNumber);
            } else {
                System.out.printf("""
                        Нет полного совпадения:
                        База данных: [№%d]
                        Фактический: [№%c%c%c]
                        """, dbSerialNumber, hundredsChar, tensChar, onesChar);
            }
        }

        System.out.println("\n6. ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ %\n");

        System.out.println("ПЕРВЫЙ СПОСОБ:");

        float deposit = 321_123.7900000f;
        float interestRate = 0.1f;

        if (deposit < 100_000) {
            interestRate = 0.05f;
        } else if (deposit <= 300_000) {
            interestRate = 0.07f;
        }

        System.out.printf("""
                Сумма вклада: %,f
                Сумма начисленного %%: %,f
                Итоговая сумма с %%: %,f
                """, deposit, deposit * interestRate, deposit * (1 + interestRate));

        System.out.println("\nВТОРОЙ СПОСОБ:");

        BigDecimal depositBd = new BigDecimal("321123.79");
        BigDecimal interestRateBd = new BigDecimal("0.1");

        if (depositBd.compareTo(new BigDecimal("100000")) < 0) {
            interestRateBd = new BigDecimal("0.05");
        } else if (depositBd.compareTo(new BigDecimal("300000")) <= 0) {
            interestRateBd = new BigDecimal("0.07");
        }

        BigDecimal interestAmountBd = depositBd.multiply(interestRateBd).setScale(2, RoundingMode.HALF_UP);
        BigDecimal totalAmountBd = depositBd.multiply(BigDecimal.ONE.add(interestRateBd))
                .setScale(2, RoundingMode.HALF_UP);

<<<<<<< HEAD
        System.out.printf("Сумма начисленного %%: %s\n", interestAmountBd);
        System.out.printf("Итоговая сумма с %%: %s\n", depositBd.add(interestAmountBd)
                .setScale(2, RoundingMode.HALF_UP));
=======
        System.out.printf("""
                Сумма вклада: %s
                Сумма начисленного %%: %s
                Итоговая сумма с %%: %s
                """, depositBd, interestAmountBd, totalAmountBd);
>>>>>>> b570f60 (Исправлены VariablesTheme и IfElseStatementTheme с учётом ряда замечаний ментора. Отдельно переработано задание "4. ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА" по теме IfElseStatementTheme.)

        System.out.println("\n7. ОПРЕДЕЛЕНИЕ ОЦЕНКИ ПО ПРЕДМЕТАМ\n");

        int historyScore = 59;
<<<<<<< HEAD
        int codingScore = 92;

=======
>>>>>>> b570f60 (Исправлены VariablesTheme и IfElseStatementTheme с учётом ряда замечаний ментора. Отдельно переработано задание "4. ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА" по теме IfElseStatementTheme.)
        int historyMark = 2;

        if (historyScore > 91) {
            historyMark = 5;
        } else if (historyScore > 73) {
            historyMark = 4;
        } else if (historyScore > 60) {
            historyMark = 3;
        }

<<<<<<< HEAD
        int codingMark = 2;

        if (codingScore > 91) {
            codingMark = 5;
        } else if (codingScore > 73) {
            codingMark = 4;
        } else if (codingScore > 60) {
            codingMark = 3;
        }

        System.out.printf("История - %d\n", historyMark);
        System.out.printf("Программирование - %d\n", codingMark);

        float avgMark = (float) (historyMark + codingMark) / 2;
        float avgScore = (float) (historyScore + codingScore) / 2;
=======
        int csScore = 92;
        int csMark = 2;

        if (csScore > 91) {
            csMark = 5;
        } else if (csScore > 73) {
            csMark = 4;
        } else if (csScore > 60) {
            csMark = 3;
        }

        System.out.printf("История - %d%n", historyMark);
        System.out.printf("Программирование - %d%n", csMark);

        float avgMark = (historyMark + csMark) / 2f;
        float avgScore = (historyScore + csScore) / 2f;
>>>>>>> b570f60 (Исправлены VariablesTheme и IfElseStatementTheme с учётом ряда замечаний ментора. Отдельно переработано задание "4. ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА" по теме IfElseStatementTheme.)

        System.out.println("Средняя оценка - " + avgMark);
        System.out.println("Средний % - " + avgScore);

        System.out.println("\n8. РАСЧЕТ ГОДОВОЙ ПРИБЫЛИ\n");

        BigDecimal monthlyRevenue = new BigDecimal("13025.233");
        BigDecimal monthlyRental = new BigDecimal("5123.018");
        BigDecimal monthlyProductionCost = new BigDecimal("9001.729");
<<<<<<< HEAD
        BigDecimal monthlyCosts = monthlyRental.add(monthlyProductionCost);
        BigDecimal monthlyProfit = monthlyRevenue.subtract(monthlyCosts);
        BigDecimal annualProfit = monthlyProfit.multiply(new BigDecimal("12"))
=======
        BigDecimal annualProfit = monthlyRevenue
                .subtract(monthlyRental.add(monthlyProductionCost))
                .multiply(new BigDecimal("12"))
>>>>>>> b570f60 (Исправлены VariablesTheme и IfElseStatementTheme с учётом ряда замечаний ментора. Отдельно переработано задание "4. ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА" по теме IfElseStatementTheme.)
                .setScale(2, RoundingMode.HALF_UP);

        System.out.print("Прибыль за год: ");

<<<<<<< HEAD
        if (annualProfit.compareTo(BigDecimal.ZERO) > 0) {
=======
        if (annualProfit.signum() > 0) {
>>>>>>> b570f60 (Исправлены VariablesTheme и IfElseStatementTheme с учётом ряда замечаний ментора. Отдельно переработано задание "4. ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА" по теме IfElseStatementTheme.)
            System.out.print('+');
        }

        System.out.println(annualProfit + " руб.\n");
    }
}