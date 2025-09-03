package com.alexgrchdez.testjava2025.application.service;

import com.alexgrchdez.testjava2025.application.port.in.CalculateApplicableRateUseCase;
import com.alexgrchdez.testjava2025.domain.model.ApplicableRate;
import com.alexgrchdez.testjava2025.domain.model.CalculateApplicableRateCommand;
import org.springframework.stereotype.Service;

@Service
public class ApplicableRateService implements CalculateApplicableRateUseCase {
    @Override
    public ApplicableRate getApplicableRate(CalculateApplicableRateCommand calculateApplicableRateCommand) {
        return null;
    }
}
