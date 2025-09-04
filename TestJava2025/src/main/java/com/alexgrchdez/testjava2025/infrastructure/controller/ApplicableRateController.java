package com.alexgrchdez.testjava2025.infrastructure.controller;

import com.alexgrchdez.testjava2025.application.port.in.CalculateApplicableRateUseCase;
import com.alexgrchdez.testjava2025.domain.model.ApplicableRate;
import com.alexgrchdez.testjava2025.domain.model.CalculateApplicableRateCommand;
import com.alexgrchdez.testjava2025.infrastructure.controller.dto.ApiErrorResponse;
import com.alexgrchdez.testjava2025.infrastructure.controller.dto.CalculateApplicableRateResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    /**
     * Controller that calculates applicable rate for the given brand, product and apply date.
     * @param productId the product id.
     * @param brandId the brand id.
     * @param applyDate the apply date.
     * @return applicable rate given input parameters or throws different Exceptions if an error occurs.
     */
    @Operation(
            summary = "Retrieves the right rate for the provided input parameters",
            description = "Retrieves rate (price) applicable given product id, brand id and a date"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rate found"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid parameters",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Rate not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class))
            )
    })
    @GetMapping
    public ResponseEntity<CalculateApplicableRateResponse> getApplicableRate(
            @Parameter(description = "Product id", required = true)
            @RequestParam Long productId,
            @Parameter(description = "Brand id", required = true)
            @RequestParam Long brandId,
            @Parameter(description = "Apply date", required = true)
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applyDate) {
        ApplicableRate applicableRate = calculateApplicableRateUseCase.getApplicableRate(new CalculateApplicableRateCommand(applyDate, productId, brandId));
        return ResponseEntity.ok(new CalculateApplicableRateResponse(applicableRate.productId(), applicableRate.brandId(),
                applicableRate.rateId(), applicableRate.period().startDateTime(), applicableRate.period().endDateTime(), applicableRate.money().price(),
                applicableRate.money().currency()));
    }
}
