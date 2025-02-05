package org.example.backendspringtechiteasycontroller.exceptions;

public class TooManyCharsException extends RuntimeException {
    public TooManyCharsException(String message) {
        super(message);
    }

    public TooManyCharsException(int id, String message) {
        super("The Input of field " + message + " Exceeds Character Limit");
    }
}
