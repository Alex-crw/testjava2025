package com.alexgrchdez.testjava2025.application.port.in;

import com.alexgrchdez.testjava2025.domain.model.ApplicableRate;
import com.alexgrchdez.testjava2025.domain.model.CalculateApplicableRateCommand;

public interface CalculateApplicableRateUseCase {

    /**
     * Calculate applicable rate given input parameters.
     * @param calculateApplicableRateCommand dto including input parameters to calculate rate.
     * @return the applicable rate given input parameters
     */
    ApplicableRate getApplicableRate(CalculateApplicableRateCommand calculateApplicableRateCommand);
}
