package com.alexgrchdez.testjava2025.application.port.in;

import com.alexgrchdez.testjava2025.domain.model.ApplicableRate;
import com.alexgrchdez.testjava2025.domain.model.CalculateApplicableRateCommand;

public interface CalculateApplicableRateUseCase {

    ApplicableRate getApplicableRate(CalculateApplicableRateCommand calculateApplicableRateCommand);
}
