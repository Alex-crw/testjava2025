package com.alexgrchdez.testjava2025.domain.model;

public record ApplicableRate( Long productId, Long brandId, Long rateId, Period period, Money money) {

    @Override
    public Long brandId() {
        return brandId;
    }

    @Override
    public Long rateId() {
        return rateId;
    }

    @Override
    public Period period() {
        return period;
    }

    @Override
    public Money money() {
        return money;
    }

    @Override
    public Long productId() {
        return productId;
    }
}
