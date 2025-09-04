package com.alexgrchdez.testjava2025.infrastructure.controller.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CalculateApplicableRateResponseTest {

    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    @Test
    void testCalculateApplicableRateShouldCreateResponseAndAccessFields() {
        CalculateApplicableRateResponse response = new CalculateApplicableRateResponse(
                35455L,
                1L,
                2L,
                LocalDateTime.of(2020, 6, 14, 15, 0),
                LocalDateTime.of(2020, 6, 14, 18, 30),
                BigDecimal.valueOf(25.45),
                "EUR"
        );

        assertThat(response.productId()).isEqualTo(35455L);
        assertThat(response.brandId()).isEqualTo(1L);
        assertThat(response.rateId()).isEqualTo(2L);
        assertThat(response.finalPrice()).isEqualByComparingTo("25.45");
        assertThat(response.currency()).isEqualTo("EUR");
    }

    @Test
    void  testCalculateApplicableRateShouldSerializeToJson() throws Exception {
        CalculateApplicableRateResponse response = new CalculateApplicableRateResponse(
                35455L,
                1L,
                2L,
                LocalDateTime.of(2020, 6, 14, 15, 0),
                LocalDateTime.of(2020, 6, 14, 18, 30),
                BigDecimal.valueOf(25.45),
                "EUR"
        );

        String json = objectMapper.writeValueAsString(response);

        assertThat(json).contains("\"productId\":35455");
        assertThat(json).contains("\"finalPrice\":25.45");
        assertThat(json).contains("\"currency\":\"EUR\"");
    }
}
