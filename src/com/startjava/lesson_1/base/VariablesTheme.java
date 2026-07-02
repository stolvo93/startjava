package com.startjava.lesson_1.base;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class VariablesTheme {
    public static void main(String[] args) {
        final LocalTime startTime = LocalTime.now();
        final long startTimeNano = System.nanoTime();
        
        System.out.println("\n1. ВЫВОД ASCII ГРАФИКИ\n");

        System.out.println(String.join("\n",
                "                     /\\",
                "   J    a  v     v  /  \\",
                "   J   a a  v   v  /_( )\\",
                "J  J  aaaaa  V V  /      \\",
                " JJ  a     a  V  /___/\\___\\"));

        System.out.println("""
                         /\\            
                   J    /  \\  v     v  a
                   J   /_( )\\  v   v  a a
                J  J  /      \\  V V  aaaaa
                 JJ  /___/\\___\\  V  a     a""");

        System.out.println("\n2. РАСЧЕТ СТОИМОСТИ ТОВАРА\n");

        float penPrice = 105.5f;
        float bookPrice = 235.23f;
        float discountPercent = 0.11f;
        float baseTotal = penPrice + bookPrice;
        float discountAmount = baseTotal * discountPercent;
        float discountedTotal = baseTotal - discountAmount;

        System.out.println("Ответ 1:");
        System.out.println("Стоимость товаров без скидки - " + baseTotal + " руб.");
        System.out.println("Сумма скидки - " + discountAmount + " руб.");
        System.out.println("Стоимость товаров со скидкой - " + discountedTotal + " руб.\n");

        BigDecimal penPriceBd = new BigDecimal("105.5");
        BigDecimal bookPriceBd = new BigDecimal("235.23");
        BigDecimal discountPercentBd = new BigDecimal("0.11");
        BigDecimal baseTotalBd = penPriceBd.add(bookPriceBd).setScale(2, RoundingMode.HALF_UP);
        BigDecimal discountAmountBd = baseTotalBd.multiply(discountPercentBd)
                .setScale(2, RoundingMode.HALF_UP);
        BigDecimal discountedTotalBd = baseTotalBd.subtract(discountAmountBd)
                .setScale(2, RoundingMode.HALF_UP);

        System.out.println("Ответ 2:");
        System.out.println("Стоимость товаров без скидки - " + baseTotalBd + " руб.");
        System.out.println("Сумма скидки - " + discountAmountBd + " руб.");
        System.out.println("Стоимость товаров со скидкой - " + discountedTotalBd + " руб.");

        System.out.println("\n3. ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ЯЧЕЕК В ТАБЛИЦЕ\n");

        int a1 = 2;
        int b2 = 5;
        System.out.println("Исходные значения ячеек:");
        System.out.println("A1 = " + a1 + ", B2 = " + b2);

        System.out.println("\nМетод: третья переменная");
        int tmp = a1;
        a1 = b2;
        b2 = tmp;
        System.out.println("A1 = " + a1 + ", B2 = " + b2);

        System.out.println("\nМетод: арифметические операции");
        a1 += b2;
        b2 = a1 - b2;
        a1 -= b2;
        System.out.println("A1 = " + a1 + ", B2 = " + b2);

        System.out.println("\nМетод: побитовый");
        a1 ^= b2;
        b2 ^= a1;
        a1 ^= b2;
        System.out.println("A1 = " + a1 + ", B2 = " + b2);

        System.out.println("\n4. ДЕКОДИРОВАНИЕ СООБЩЕНИЯ\n");

        int codeA = 1055;
        int codeB = 1088;
        int codeC = 1080;
        int codeD = 1074;
        int codeE = 1077;
        int codeF = 1090;
        System.out.printf("%-6d%-6d%-6d%-6d%-6d%-6d%n", codeA, codeB, codeC, codeD, codeE, codeF);
        System.out.printf("%-6c%-6c%-6c%-6c%-6c%-6c%n", codeA, codeB, codeC, codeD, codeE, codeF);

        System.out.println("\n5. АНАЛИЗ КОДА ТОВАРА\n");

        int productCode = 756;
        int productCategory = productCode / 100;
        int productSubcategory = productCode % 100 / 10;
        int packagingType = productCode % 10;
        int checksum = productCategory + productSubcategory + packagingType;
        int verificationCode = productCategory * productSubcategory * packagingType;

        System.out.printf("""
                Код товара: %d
                  категория товара - %d
                  подкатегория - %d
                  тип упаковки - %d
                Контрольная сумма = %d
                Проверочный код = %d
                """,
                productCode, productCategory, productSubcategory, packagingType, checksum, verificationCode);

        System.out.println("\n6. ТЕСТИРОВАНИЕ ДАТЧИКОВ ПЕРЕД ЗАПУСКОМ РАКЕТЫ\n");

        byte temperature = Byte.MAX_VALUE;
        System.out.printf("""
                [Температура, °C]:
                  Исходное: %4d
                     +1: %7d
                     -1: %7d
                %n""", temperature, ++temperature, --temperature);

        short pressure = Short.MAX_VALUE;
        System.out.printf("""
                [Давление, кПа]:
                  Исходное: %,6d
                     +1: %,9d
                     -1: %,9d
                %n""", pressure, ++pressure, --pressure);

        char statusCode = Character.MAX_VALUE;
        System.out.printf("""
                [Код состояния системы]:
                  Исходное: %,6d
                     +1: %,9d
                     -1: %,9d
                %n""", (int) statusCode, (int) ++statusCode, (int) --statusCode);

        int traveledDistance = Integer.MAX_VALUE;
        System.out.printf("""
                [Пройденное расстояние, м]:
                  Исходное: %,11d
                     +1: %,16d
                     -1: %,16d
                %n""", traveledDistance, ++traveledDistance, --traveledDistance);

        long timeSinceLaunch = Long.MAX_VALUE;
        System.out.printf("""
                [Время с момента старта, пс]:
                  Исходное: %,20d
                     +1: %,28d
                     -1: %,28d
                """, timeSinceLaunch, ++timeSinceLaunch, --timeSinceLaunch);

        System.out.println("\n7. ВЫВОД ПАРАМЕТРОВ JVM И ОС\n");

        double mb = 1024 * 1024;
        Runtime rt = Runtime.getRuntime();
        int availableCoresNumber = rt.availableProcessors();
        double allocatedMemory = rt.totalMemory() / mb;
        double freeMemory = rt.freeMemory() / mb;
        double usedMemory = allocatedMemory - freeMemory;
        double maxMemory = rt.maxMemory() / mb;

        System.out.printf("""
                Характеристики JVM:
                  доступное число ядер      - %d
                  выделенная память (МБ)    - %.1f
                  свободная память (МБ)     - %.1f
                  используемая память (МБ)  - %.1f
                  максимально доступная
                  для выделения память (МБ) - %.1f
                %n""", availableCoresNumber, allocatedMemory, freeMemory, usedMemory, maxMemory);

        String userDirectory = System.getProperty("user.dir");
        String osVersion = System.getProperty("os.name") + " " + System.getProperty("os.version");
        String javaVersion = System.getProperty("java.version");
        String pathSeparator = System.getProperty("file.separator");
        System.out.printf("""
                Характеристики ОС:
                  системный диск: %.1s
                  версия ОС: %s
                  версия Java: %s
                  символ разделения пути: '%s'
                """, userDirectory, osVersion, javaVersion, pathSeparator);

        System.out.println("\n8. ЗАМЕР ВРЕМЕНИ РАБОТЫ КОДА\n");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        String startTimeFormatted = dtf.format(startTime);
        String finishTimeFormatted = dtf.format(LocalTime.now());
        long finishTimeNano = System.nanoTime();
        double ns = 1e9;
        double timeElapsed = (finishTimeNano - startTimeNano) / ns;

        System.out.printf("""
                | Старт проверки | %s |
                +-------------------------------+
                | Финиш проверки | %s |
                +-------------------------------+
                | Время работы   | %6.3f сек   |
                %n""", startTimeFormatted, finishTimeFormatted, timeElapsed);
    }
}
