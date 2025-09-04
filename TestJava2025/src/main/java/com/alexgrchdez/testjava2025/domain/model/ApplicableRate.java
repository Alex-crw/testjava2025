package com.alexgrchdez.testjava2025.domain.model;

public record ApplicableRate(Long productId, Long brandId, Long rateId, Period period, Money money) {

}
