package com.alexgrchdez.testjava2025.domain.model;

import java.time.LocalDateTime;

public record CalculateApplicableRateCommand(LocalDateTime applyDate, Long productId, Long brandId) {
}
