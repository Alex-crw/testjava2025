package com.alexgrchdez.testjava2025.infrastructure.controller;

import com.alexgrchdez.testjava2025.application.port.in.CalculateApplicableRateUseCase;
import com.alexgrchdez.testjava2025.application.service.ApplicableRateService;
import com.alexgrchdez.testjava2025.domain.exception.ApplicableRateNotFoundException;
import com.alexgrchdez.testjava2025.domain.model.ApplicableRate;
import com.alexgrchdez.testjava2025.domain.model.Money;
import com.alexgrchdez.testjava2025.domain.model.Period;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



@ExtendWith(MockitoExtension.class)
class ApplicableRateControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ApplicableRateService applicableRateService;

    @InjectMocks
    private ApplicableRateController controller;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }


    @Test
    void testGetApplicableRateShouldReturn200WhenServiceReturnsResponse() throws Exception {
        ApplicableRate response = new ApplicableRate(35455L, 1L, 1L,
                new Period(LocalDateTime.of(2020, 6, 14, 0, 0), LocalDateTime.of(2020, 12, 31, 23, 59)),
                new Money(BigDecimal.valueOf(35.50), "EUR"));

        when(applicableRateService.getApplicableRate(any())).thenReturn(response);

        mockMvc.perform(get("/applicable-rate")
                        .param("productId","35455")
                        .param("brandId","1")
                        .param("applyDate","2020-06-14T10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.finalPrice").value(35.50));
    }

    @Test
    void shouldReturn404WhenRateNotFound() throws Exception {
        given(applicableRateService.getApplicableRate(any()))
                .willThrow(new ApplicableRateNotFoundException(999L, 1L, LocalDateTime.of(2020, 06, 14, 10, 0, 0)));

        mockMvc.perform(get("/applicable-rate")
                        .param("productId", "999")
                        .param("brandId", "1")
                        .param("applyDate", "2020-06-14T10:00:00"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No applicable rate found for product id 999 and brand id 1 with applyDate 2020-06-14T10:00"));
    }
}
