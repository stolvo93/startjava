package com.startjava.lesson_2_3_4.guess;

public class NumberNotInRangeException extends RuntimeException {
    public NumberNotInRangeException(String message) {
        super(message);
    }
}
