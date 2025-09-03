package com.alexgrchdez.testjava2025.domain.model;

import java.math.BigDecimal;

public record Money(BigDecimal price, String currency ) {

    @Override
    public BigDecimal price() {
        return price;
    }

    @Override
    public String currency() {
        return currency;
    }
}
