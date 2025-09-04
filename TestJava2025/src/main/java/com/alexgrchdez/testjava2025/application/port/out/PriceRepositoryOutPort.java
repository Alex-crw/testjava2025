package com.alexgrchdez.testjava2025.application.port.out;

import com.alexgrchdez.testjava2025.domain.model.ApplicableRate;
import com.alexgrchdez.testjava2025.domain.model.CalculateApplicableRateCommand;

import java.util.Optional;

public interface PriceRepositoryOutPort {
    Optional<ApplicableRate> getApplicableRate(CalculateApplicableRateCommand calculateApplicableRateCommand);
}
