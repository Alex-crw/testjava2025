package com.alexgrchdez.testjava2025.application.service;

import com.alexgrchdez.testjava2025.application.port.in.CalculateApplicableRateUseCase;
import com.alexgrchdez.testjava2025.application.port.out.PriceRepositoryOutPort;
import com.alexgrchdez.testjava2025.domain.exception.ApplicableRateNotFoundException;
import com.alexgrchdez.testjava2025.domain.model.ApplicableRate;
import com.alexgrchdez.testjava2025.domain.model.CalculateApplicableRateCommand;
import org.springframework.stereotype.Service;

@Service
public class ApplicableRateService implements CalculateApplicableRateUseCase {

    private final PriceRepositoryOutPort priceRepositoryOutPort;

    public ApplicableRateService(PriceRepositoryOutPort priceRepositoryOutPort) {
        this.priceRepositoryOutPort = priceRepositoryOutPort;
    }

    /**
     * Calculate applicable rate given input parameters.
     * @param calculateApplicableRateCommand dto including input parameters to calculate rate.
     * @return the applicable rate or ApplicableRateNotFoundException if no rate found.
     */
    @Override
    public ApplicableRate getApplicableRate(CalculateApplicableRateCommand calculateApplicableRateCommand) {
        return this.priceRepositoryOutPort.getApplicableRate(calculateApplicableRateCommand)
                .orElseThrow(() -> new ApplicableRateNotFoundException(
                        calculateApplicableRateCommand.productId(),
                        calculateApplicableRateCommand.brandId(),
                        calculateApplicableRateCommand.applyDate()
                ));
    }
}
