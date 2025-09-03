package com.alexgrchdez.testjava2025.infrastructure.persistance;

import com.alexgrchdez.testjava2025.application.port.out.PriceRepositoryOutPort;
import com.alexgrchdez.testjava2025.domain.model.ApplicableRate;
import com.alexgrchdez.testjava2025.domain.model.CalculateApplicableRateCommand;
import com.alexgrchdez.testjava2025.domain.model.Money;
import com.alexgrchdez.testjava2025.domain.model.Period;
import com.alexgrchdez.testjava2025.infrastructure.controller.dto.PriceEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaPriceRepositoryAdapter implements PriceRepositoryOutPort {


    private final SpringDataPriceRepository springDataUserRepository;

    public JpaPriceRepositoryAdapter(SpringDataPriceRepository springDataUserRepository) {
        this.springDataUserRepository = springDataUserRepository;
    }

    @Override
    public Optional<ApplicableRate> getApplicableRate(CalculateApplicableRateCommand calculateApplicableRateCommand) {
        List<PriceEntity> applicableRate = this.springDataUserRepository.findApplicableRate(calculateApplicableRateCommand.productId(),
                calculateApplicableRateCommand.brandId(), calculateApplicableRateCommand.applyDate());
        return applicableRate.stream().findFirst().map(p -> new ApplicableRate( p.getProductId(), p.getBrandId(), p.getRateId(),
                new Period(p.getStartDateTime(), p.getEndDateTime()), new Money(p.getPrice(), p.getCurrency())));
    }
}
