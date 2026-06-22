public class NonBooleanMethods {
    public void printDescription() {
        System.out.println("\nНЕ BOOLEAN-МЕТОДЫ:\n");
        findLongestWord();
        selectMenuItem();
        calculateAvgMark();
        countUniqueWords();
        printErrorMessage();
        syncData();
        restoreBackup();
        pauseDownload();
        resetFactorySettings();
        writeToFile();
        convertCelsiusToFahrenheit();
        enterMathExpression();
        determineWinner();
        findBooksByAuthor();
    }

    public void findLongestWord() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> найти самое длинное слово в предложении из книги по Java");
    }

    public void selectMenuItem() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> выбрать пункт меню в текстовом редакторе на macOS");
    }

    public void calculateAvgMark() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> вычислить среднее значение оценок в школе №1234");
    }

    public void countUniqueWords() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> подсчитать количество уникальных слов в \"Война и Мир\"");
    }

    public void printErrorMessage() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> вывести сообщение об ошибке");
    }

    public void syncData() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> синхронизировать данные с облачным хранилищем");
    }

    public void restoreBackup() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> восстановить данные из резервной копии от 11.03.2024");
    }

    public void pauseDownload() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> приостановить загрузку mp3-файла группы \"Ария\"");
    }

    public void resetFactorySettings() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> сбросить настройки до заводских для пылесоса Mi");
    }

    public void writeToFile() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> записать содержимое в файл по указанному пути на флешку");
    }

    public void convertCelsiusToFahrenheit() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> преобразовать температуру из Цельсия в Фаренгейт");
    }

    public void enterMathExpression() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> ввести математическое выражение с тремя аргументами");
    }

    public void determineWinner() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> выявить победителя среди гонщиков игры \"Need For Speed\"");
    }

    public void findBooksByAuthor() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> найти книгу по имени писателя");
    }
}