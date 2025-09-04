package com.alexgrchdez.testjava2025.application.port.out;

import com.alexgrchdez.testjava2025.domain.model.ApplicableRate;
import com.alexgrchdez.testjava2025.domain.model.CalculateApplicableRateCommand;

import java.util.Optional;

public interface PriceRepositoryOutPort {
    /**
     * Calculate applicable rate given input parameters.
     * @param calculateApplicableRateCommand dto including input parameters to calculate rate.
     * @return Optional containing applicable rate or empty if no rate found.
     */
    Optional<ApplicableRate> getApplicableRate(CalculateApplicableRateCommand calculateApplicableRateCommand);
}
