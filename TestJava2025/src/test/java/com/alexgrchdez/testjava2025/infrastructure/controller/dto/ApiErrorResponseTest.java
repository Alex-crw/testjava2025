package com.alexgrchdez.testjava2025.infrastructure.controller.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ApiErrorResponseTest {

    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    @Test
    void testApiErrorShouldCreateApiErrorResponseField() {
        ApiErrorResponse error = new ApiErrorResponse("MISSING_PARAMETER", "Missing parameter");

        assertThat(error.code().equals("MISSING_PARAMETER"));
        assertThat(error.message()).isEqualTo("Missing parameter");
    }

    @Test
    void testApiErrorShouldSerializeToJson() throws Exception {
        ApiErrorResponse error = new ApiErrorResponse("RATE_NOT_FOUND", "Not found");

        String json = objectMapper.writeValueAsString(error);

        assertThat(json).contains("\"code\":\"RATE_NOT_FOUND\"");
        assertThat(json).contains("\"message\":\"Not found\"");
    }
}
