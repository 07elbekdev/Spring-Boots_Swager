package it.springboot.exception;

public class MyUniversalException extends RuntimeException {
    public MyUniversalException() {
    }

    public MyUniversalException(String message) {
        super(message);
    }
}