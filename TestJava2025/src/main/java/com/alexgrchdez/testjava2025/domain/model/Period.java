package com.alexgrchdez.testjava2025.domain.model;

import java.time.LocalDateTime;

public record Period(LocalDateTime startDateTime, LocalDateTime endDateTime) {

    @Override
    public LocalDateTime startDateTime() {
        return startDateTime;
    }

    @Override
    public LocalDateTime endDateTime() {
        return endDateTime;
    }
}
