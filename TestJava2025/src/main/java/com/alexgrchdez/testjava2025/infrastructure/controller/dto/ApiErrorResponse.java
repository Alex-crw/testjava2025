package com.alexgrchdez.testjava2025.infrastructure.controller.dto;

import java.time.LocalDateTime;

public record ApiErrorResponse( String code, String message, LocalDateTime timestamp ) {
    public ApiErrorResponse( String code, String message ) {
        this(code, message, LocalDateTime.now() );
    }
}
