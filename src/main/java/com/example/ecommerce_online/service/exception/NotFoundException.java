package com.example.ecommerce_online.service.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
