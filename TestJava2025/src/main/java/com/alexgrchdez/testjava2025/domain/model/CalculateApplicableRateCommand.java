package com.alexgrchdez.testjava2025.domain.model;

import java.time.LocalDateTime;

public record CalculateApplicableRateCommand(LocalDateTime applyDate, Long productId, Long brandId) {
    @Override
    public LocalDateTime applyDate() {
        return applyDate;
    }

    @Override
    public Long productId() {
        return productId;
    }

    @Override
    public Long brandId() {
        return brandId;
    }
}
