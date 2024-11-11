package com.lelo.appointment.tools;

@org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException(Integer id) {
        super("not found id: " + id);
    }
}