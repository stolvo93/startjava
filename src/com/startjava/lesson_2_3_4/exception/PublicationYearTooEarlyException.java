package com.startjava.lesson_2_3_4.exception;

public class PublicationYearTooEarlyException extends RuntimeException {
    public PublicationYearTooEarlyException(String message) {
        super(message);
    }
}