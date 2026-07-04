package com.startjava.lesson_2_3_4.method.naming;

public class BooleanMethods {
    public boolean isRunning() {
        System.out.print(Methods.getCurrentMethodName() +
                "() -> программа выполняется далее или завершается? ");
        return true;
    }

    public boolean hasUniqueDigit() {
        System.out.print(Methods.getCurrentMethodName() +
                "() -> последовательность содержит уникальную цифру? ");
        return false;
    }

    public boolean isLetter() {
        System.out.print(Methods.getCurrentMethodName() +
                "() -> пользователь ввел букву или что-то другое? ");
        return true;
    }

    public boolean hasEqualDigits() {
        System.out.print(Methods.getCurrentMethodName() +
                "() -> в проверяемых числах, есть равные цифры? ");
        return false;
    }

    public boolean hasAttempts() {
        System.out.print(Methods.getCurrentMethodName() +
                "() -> в игре \"Марио\" остались попытки? ");
        return true;
    }

    public boolean isBlank() {
        System.out.print(Methods.getCurrentMethodName() +
                "() -> пользователь ввёл пустую строку или из одних пробелов? ");
        return false;
    }

    public boolean isEven() {
        System.out.print(Methods.getCurrentMethodName() +
                "() -> на кубике, который бросил компьютер, выпало четное число? ");
        return true;
    }

    public boolean isValidPath() {
        System.out.print(Methods.getCurrentMethodName() +
                "() -> путь до файла, который вы ищете на SSD, действительный? ");
        return false;
    }

    public boolean isExistFile() {
        System.out.print(Methods.getCurrentMethodName() +
                "() -> файл по указанному адресу существует? ");
        return true;
    }
}