package com.example.user_service.exception;

public class UserFieldNotUniqueException extends RuntimeException {
    public UserFieldNotUniqueException(String message) {
        super(message);
    }
}
