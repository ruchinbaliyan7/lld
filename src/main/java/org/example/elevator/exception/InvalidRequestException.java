package org.example.elevator.exception;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String message ) {
        super(message);
    }
}
