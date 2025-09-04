package com.alexgrchdez.testjava2025.infrastructure.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Api info error")
public record ApiErrorResponse( @Schema(description = "Internal code error", example = "INVALID_PARAMETER") String code,
                                @Schema(description = "Detailed error message", example = "brandId must be a long") String message,
                                @Schema(description = "Timestamp", example = "2025-09-03T21:44:45.2557126") LocalDateTime timestamp ) {
    public ApiErrorResponse( String code, String message ) {
        this(code, message, LocalDateTime.now() );
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public LocalDateTime timestamp() {
        return timestamp;
    }
}
