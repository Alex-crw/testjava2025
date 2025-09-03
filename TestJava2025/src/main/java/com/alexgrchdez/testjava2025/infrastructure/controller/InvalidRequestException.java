package com.alexgrchdez.testjava2025.infrastructure.controller;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String message) {
        super(message);
    }
}
