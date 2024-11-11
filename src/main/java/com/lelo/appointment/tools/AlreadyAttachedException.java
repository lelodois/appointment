package com.lelo.appointment.tools;

@org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY)
public class AlreadyAttachedException extends RuntimeException {
    public AlreadyAttachedException(Integer id) {
        super("already attached to another official " + id);
    }
}
