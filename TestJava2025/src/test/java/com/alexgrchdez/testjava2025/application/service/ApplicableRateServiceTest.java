package com.alexgrchdez.testjava2025.application.service;

import com.alexgrchdez.testjava2025.application.port.in.CalculateApplicableRateUseCase;
import com.alexgrchdez.testjava2025.application.port.out.PriceRepositoryOutPort;
import com.alexgrchdez.testjava2025.domain.model.ApplicableRate;
import com.alexgrchdez.testjava2025.domain.model.CalculateApplicableRateCommand;
import com.alexgrchdez.testjava2025.domain.model.Money;
import com.alexgrchdez.testjava2025.domain.model.Period;
import com.alexgrchdez.testjava2025.infrastructure.persistance.PriceEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApplicableRateServiceTest {

    @Test
    void testCalculateReturnsCorrectRate() {

        PriceRepositoryOutPort repository = mock( PriceRepositoryOutPort.class );

        PriceEntity entity = new PriceEntity(
                1L, 1L, 35455L,
                LocalDateTime.of(2020, 6, 14, 0, 0),
                1,
                LocalDateTime.of(2020, 12, 31, 23, 59),
                BigDecimal.valueOf(35.50),
                "EUR"
        );
        ApplicableRate rate = new ApplicableRate(1L, 1L, 35455L,
                new Period(LocalDateTime.of(2020, 6, 14, 0, 0), LocalDateTime.of(2020, 12, 31, 23, 59)),
                        new Money( BigDecimal.valueOf(35.50), "EUR"));
        when(repository.getApplicableRate(any(CalculateApplicableRateCommand.class)))
                .thenReturn(Optional.of(rate));

        ApplicableRateService serviceToTest = new ApplicableRateService( repository );

        ApplicableRate result = serviceToTest.getApplicableRate( new CalculateApplicableRateCommand(
                LocalDateTime.of(2020,11,25,23,59),
                1L, 1L
        ));

        assertNotNull(result);
        assertEquals(BigDecimal.valueOf(35.50), result.money().price());
    }
}
