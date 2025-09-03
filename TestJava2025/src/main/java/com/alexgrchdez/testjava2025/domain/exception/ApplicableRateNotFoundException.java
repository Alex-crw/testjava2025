package com.alexgrchdez.testjava2025.domain.exception;

import java.time.LocalDateTime;

public class ApplicableRateNotFoundException extends RuntimeException {

    public ApplicableRateNotFoundException(Long productId, Long brandId, LocalDateTime applyDate ) {
        super("No applicable rate found for product id " + productId + " and brand id " + brandId + " with applyDate " + applyDate );
    }
}
