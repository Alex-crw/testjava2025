package com.alexgrchdez.testjava2025.infrastructure.controller.dto;

import com.alexgrchdez.testjava2025.application.port.in.CalculateApplicableRateUseCase;
import com.alexgrchdez.testjava2025.domain.model.ApplicableRate;
import com.alexgrchdez.testjava2025.domain.model.CalculateApplicableRateCommand;
import com.alexgrchdez.testjava2025.infrastructure.controller.CalculateApplicableRateResponse;
import com.alexgrchdez.testjava2025.infrastructure.controller.InvalidRequestException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/applicable-rate")
public class ApplicableRateController {

    private final CalculateApplicableRateUseCase calculateApplicableRateUseCase;

    public ApplicableRateController(CalculateApplicableRateUseCase calculateApplicableRateUseCase) {
        this.calculateApplicableRateUseCase = calculateApplicableRateUseCase;
    }

    @GetMapping
    public ResponseEntity<CalculateApplicableRateResponse> getApplicableRate(@RequestParam Long productId,
                                                                             @RequestParam Long brandId,
                                                                             @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applyDate) {
        if(productId == null || brandId == null || applyDate == null) {
            throw new InvalidRequestException("ProductId, brandId and applyDate cannot be null or empty.");
        }
        ApplicableRate applicableRate = calculateApplicableRateUseCase.getApplicableRate( new CalculateApplicableRateCommand( applyDate, productId, brandId) );
        return ResponseEntity.ok( new CalculateApplicableRateResponse( applicableRate.productId(), applicableRate.brandId(),
                applicableRate.rateId(), applicableRate.period().startDateTime(), applicableRate.period().endDateTime(), applicableRate.money().price(),
                applicableRate.money().currency() ) );
    }
}
