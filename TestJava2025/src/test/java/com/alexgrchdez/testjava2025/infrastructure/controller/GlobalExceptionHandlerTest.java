package com.alexgrchdez.testjava2025.infrastructure.controller;

import com.alexgrchdez.testjava2025.domain.exception.ApplicableRateNotFoundException;
import com.alexgrchdez.testjava2025.infrastructure.controller.dto.ApiErrorResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler handler;

    @BeforeEach
    void setUp() {
        handler = new GlobalExceptionHandler();
    }

    @Test
    void testHandleNotFoundShouldHandleApplicableRateNotFoundException() {
        ApplicableRateNotFoundException ex =
                new ApplicableRateNotFoundException(1L, 1L, LocalDateTime.of(2019, 1, 1, 0, 0));

        ResponseEntity<ApiErrorResponse> response = handler.handleNotFound(ex);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("RATE_NOT_FOUND", response.getBody().code());
        assertEquals("No applicable rate found for product id 1 and brand id 1 with applyDate 2019-01-01T00:00", response.getBody().message());
        assertNotNull(response.getBody().timestamp());
    }

    @Test
    void testHandleMissingParametersShouldHandleMissingServletRequestParameterException() {
        MissingServletRequestParameterException ex =
                new MissingServletRequestParameterException("productId", "Long");

        ResponseEntity<ApiErrorResponse> response = handler.handleMissingParam(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("MISSING_PARAMETER", response.getBody().code());
        assertEquals("productId is mandatory", response.getBody().message());
        assertNotNull(response.getBody().timestamp());
    }

    @Test
    void testHandleTypeMissmatchShouldHandleMethodArgumentTypeMismatchException() {
        MethodArgumentTypeMismatchException ex =
                new MethodArgumentTypeMismatchException("brandId", Long.class, "brandId", null, null);

        ResponseEntity<ApiErrorResponse> response = handler.handleTypeMismatch(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("INVALID_PARAMETER", response.getBody().code());
        assertEquals("brandId must be of type Long", response.getBody().message());
        assertNotNull(response.getBody().timestamp());
    }

    @Test
    void testHandleGenericExceptionShouldHandleGenericException() {
        Exception ex = new Exception("Unexpected error");

        ResponseEntity<ApiErrorResponse> response = handler.handleGenericException(ex);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("INTERNAL_ERROR", response.getBody().code());
        assertEquals("Unexpected error", response.getBody().message());
        assertNotNull(response.getBody().timestamp());
    }
}
