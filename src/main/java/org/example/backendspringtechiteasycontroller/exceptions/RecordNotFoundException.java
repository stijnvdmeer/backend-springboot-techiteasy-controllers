package org.example.backendspringtechiteasycontroller.exceptions;

import org.springframework.http.HttpStatusCode;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String message) {
        super(message);
    }

    public RecordNotFoundException(long id) {
        super("Television with the id of " + id + " does not exist");
    }

}
