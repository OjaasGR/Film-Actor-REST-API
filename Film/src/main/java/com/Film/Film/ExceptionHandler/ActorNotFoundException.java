package com.Film.Film.ExceptionHandler;

public class ActorNotFoundException extends RuntimeException {
    public ActorNotFoundException(String message) {
        super(message);
    }
}
