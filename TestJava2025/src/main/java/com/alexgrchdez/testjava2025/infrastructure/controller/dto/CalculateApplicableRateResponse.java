package com.alexgrchdez.testjava2025.infrastructure.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CalculateApplicableRateResponse(Long productId, Long brandId, Long rateId, LocalDateTime startDateTime,
                                              LocalDateTime endDateTime,
                                              BigDecimal finalPrice, String currency) {
}
