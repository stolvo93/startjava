package com.startjava.lesson_2_3_4.bookcase;

public enum MenuItem {
    ADD_BOOK("Добавить книгу"),
    FIND_BOOK("Найти книгу"),
    REMOVE_BOOK("Удалить книгу"),
    CLEAR_BOOKCASE("Очистить шкаф"),
    QUIT("Завершить работу");

    private final String label;

    MenuItem(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}