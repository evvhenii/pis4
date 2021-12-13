package com.example.pis4.exception.base;

import org.springframework.http.HttpStatus;

import java.util.function.Supplier;

public class NotFoundException extends BaseException {

    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }

    public static Supplier<NotFoundException> of(String message) {
        return () -> new NotFoundException(message);
    }

}
