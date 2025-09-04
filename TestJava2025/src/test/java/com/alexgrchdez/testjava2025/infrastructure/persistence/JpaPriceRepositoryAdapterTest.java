package com.alexgrchdez.testjava2025.infrastructure.persistence;

import com.alexgrchdez.testjava2025.domain.model.ApplicableRate;
import com.alexgrchdez.testjava2025.domain.model.CalculateApplicableRateCommand;
import com.alexgrchdez.testjava2025.infrastructure.persistance.JpaPriceRepositoryAdapter;
import com.alexgrchdez.testjava2025.infrastructure.persistance.SpringDataPriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JpaPriceRepositoryAdapterTest {

    @Autowired
    private SpringDataPriceRepository springDataRepo;

    private JpaPriceRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        adapter = new JpaPriceRepositoryAdapter(springDataRepo);
    }

    @Test
    void testGetApplicableRateShouldReturnCorrectRate() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 16, 0);

        Optional<ApplicableRate> result = adapter.getApplicableRate(
                new CalculateApplicableRateCommand(date, 35455L, 1L)
        );

        assertThat(result).isPresent();
        assertThat(result.get().money().price()).isEqualByComparingTo("25.45");
    }

    @Test
    void testGetApplicableRateShouldReturnNoRate() {
        LocalDateTime date = LocalDateTime.of(2019, 1, 1, 0, 0);

        Optional<ApplicableRate> result = adapter.getApplicableRate(
                new CalculateApplicableRateCommand(date, 35455L, 1L)
        );

        assertThat(result).isEmpty();
    }
}
