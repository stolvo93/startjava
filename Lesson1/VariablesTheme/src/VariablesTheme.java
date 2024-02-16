public class VariablesTheme {
    public static void main(String[] args) {
        System.out.println("1. Вывод характеристик компьютера");

        //Диагональ экрана
        double screenSize = 15.1d;
        System.out.println("Диагональ экрана = " + screenSize + "\"");

        //Количество ядер процессора
        byte cpuCoreCount = 8;
        System.out.println("Количество ядер процессора = " + cpuCoreCount);

        //Скорость процессора
        float cpuClockRate = 2.3f;
        System.out.println("Скорость процессора = " + cpuClockRate + " ГГц");

        //Емкость хранилища
        short ssdCapacity = 500;
        System.out.println("Емкость хранилища = " + ssdCapacity + " ГБ");

        //Объем памяти
        long ramAmount = 32768L;
        System.out.println("Объем памяти = " + ramAmount + " МБ");

        //Объем графической памяти
        int vramAmount = 8192;
        System.out.println("Объем графической памяти = " + vramAmount + " МБ");

        //Класс энергоэффективности
        char energyEfficiencyClass = 'A';
        System.out.println("Класс энергоэффективности = " + energyEfficiencyClass);

        //Имеется сертификат
        boolean isCertified = true;
        System.out.println("Имеется сертификат = " + isCertified + "\n");

        System.out.println("2. Расчет стоимости товара со скидкой");
        
        //цена ручки
        int penPrice = 100;
        
        //цена книги
        int bookPrice = 200;
        
        //размер скидки
        double discount = 0.11;
        
        //общая стоимость товаров без скидки
        int totalCost = penPrice + bookPrice;
        System.out.println("Общая стоимость товаров без скидки = " + totalCost);

        //сумма скидки
        double discountSum = totalCost * discount;
        System.out.println("Сумма скидки = " + discountSum);

        //общая стоимость товаров со скидкой
        double totalCostDiscounted = totalCost - discountSum;
        System.out.println("Общая стоимость товаров со скидкой = " + totalCostDiscounted + "\n");

        System.out.println("3. Вывод слова JAVA\n" +
                "   J    a  v     v  a\n" +
                "   J   a a  v   v  a a\n" +
                "J  J  aaaaa  V V  aaaaa\n" +
                " JJ  a     a  V  a     a\n");

        System.out.println("4. Вывод min и max значений целых числовых типов");

        byte a = 127;
        System.out.println("Тип byte:\n" + a);
        System.out.println(++a);
        System.out.println(--a + "\n");

        short b = 32767;
        System.out.println("Тип short:\n" + b);
        System.out.println(++b);
        System.out.println(--b + "\n");

        int c = 2_147_483_647;
        System.out.println("Тип int:\n" + c);
        System.out.println(++c);
        System.out.println(--c + "\n");

        long d = 9_223_372_036_854_775_807L;
        System.out.println("Тип long:\n" + d);
        System.out.println(++d);
        System.out.println(--d + "\n");

        System.out.println("5. Перестановка значений переменных");

        int x = 2;
        int y = 5;

        //с помощью третьей переменной
        System.out.println("C помощью третьей переменной:");
        System.out.println("Исходные значения переменных: x = " + x + ", y = " + y);
        int z = x;
        x = y;
        y = z;
        System.out.println("Новые значения переменных:    x = " + x + ", y = " + y + "\n");

        //с помощью арифметических операций
        System.out.println("C помощью арифметических операций:");
        System.out.println("Исходные значения переменных: x = " + x + ", y = " + y);
        x -= y;
        y += x;
        x = y - x;
        System.out.println("Новые значения переменных:    x = " + x + ", y = " + y + "\n");

        //с помощью побитовой операции ^
        System.out.println("C помощью побитовой операции ^:");
        System.out.println("Исходные значения переменных: x = " + x + ", y = " + y);
        y ^= x;
        x ^= y;
        y ^= x;
        System.out.println("Новые значения переменных:    x = " + x + ", y = " + y + "\n");

        System.out.println("6. Вывод символов и их кодов");

        char ch1 = '$';
        System.out.println(ch1 + " " + (int) ch1);
        char ch2 = '*';
        System.out.println(ch2 + " " + (int) ch2);
        char ch3 = '@';
        System.out.println(ch3 + " " + (int) ch3);
        char ch4 = '|';
        System.out.println(ch4 + " " + (int) ch4);
        char ch5 = '~';
        System.out.println(ch5 + " " + (int) ch5 + "\n");

        System.out.println("7. Вывод в консоль ASCII-арта Дюка");

        char slash = '/';
        char backslash = '\\';
        char underscore = '_';
        char openingBracket = '(';
        char closingBracket = ')';

        System.out.println("    " + slash + backslash +
                "\n   " + slash + "  " + backslash +
                "\n  " + slash + underscore + openingBracket + " " + closingBracket + backslash +
                "\n " + slash + "      " + backslash +
                "\n" + slash + underscore + underscore + underscore + underscore + slash +
                backslash + underscore + underscore + backslash + "\n");

        System.out.println("8. Вывод количества сотен, десятков и единиц числа");

        int number = 123;
        System.out.println("Число N содержит:\n");

        //количество сотен
        int hundredsCount = number / 100;
        System.out.println("  сотен - " + hundredsCount);

        //количество десятков
        int tensCount = number % 100 / 10;
        System.out.println("  десятков - " + tensCount);

        //количество единиц
        int onesCount = number % 100 % 10;
        System.out.println("  единиц - " + onesCount);

        //сумма цифр
        int digitSum = hundredsCount + tensCount + onesCount;
        System.out.println("Сумма его цифр = " + digitSum);

        //произведение
        int digitProduct = hundredsCount * tensCount * onesCount;
        System.out.println("Произведение = " + digitProduct + "\n");

        System.out.println("9. Вывод времени");

        int secondsTotal = 86399;
        int hours = secondsTotal / 3600;
        int minutes = secondsTotal % 3600 / 60;
        int seconds = secondsTotal % 3600 % 60;

        System.out.println(hours + ":" + minutes + ":" + seconds);
    }
}