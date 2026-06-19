public class Main {
    public static void main(String[] args) {
        System.out.println("\n1. НЕ BOOLEAN-МЕТОДЫ\n");

        NonBooleanMethods nonBooleanMethodsInstance = new NonBooleanMethods();
        
        nonBooleanMethodsInstance.getLongestWord();
        nonBooleanMethodsInstance.selectMenuItem();
        nonBooleanMethodsInstance.getAvgMark();
        nonBooleanMethodsInstance.getUniqueWordsCount();
        nonBooleanMethodsInstance.printErrorMessage();
        nonBooleanMethodsInstance.syncData();
        nonBooleanMethodsInstance.restoreBackup();
        nonBooleanMethodsInstance.pauseDownload();
        nonBooleanMethodsInstance.resetFactorySettings();
        nonBooleanMethodsInstance.writeToFile();
        nonBooleanMethodsInstance.convertCelsiusToFahrenheit();
        nonBooleanMethodsInstance.enterMathExpression();
        nonBooleanMethodsInstance.determineWinner();
        nonBooleanMethodsInstance.getBooks();

        System.out.println("\n2. BOOLEAN-МЕТОДЫ\n");

        BooleanMethods booleanMethodsInstance = new BooleanMethods();

        System.out.println(booleanMethodsInstance.isRunning());
        System.out.println(booleanMethodsInstance.hasUniqueDigit());
        System.out.println(booleanMethodsInstance.isLetter());
        System.out.println(booleanMethodsInstance.hasEqualDigits());
        System.out.println(booleanMethodsInstance.hasAttempts());
        System.out.println(booleanMethodsInstance.isBlank());
        System.out.println(booleanMethodsInstance.isEven());
        System.out.println(booleanMethodsInstance.isValidPath());
        System.out.println(booleanMethodsInstance.isExistFile());
    }
}