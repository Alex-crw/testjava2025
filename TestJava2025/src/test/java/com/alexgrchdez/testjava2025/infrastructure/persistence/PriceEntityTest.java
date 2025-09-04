package com.alexgrchdez.testjava2025.infrastructure.persistence;

import com.alexgrchdez.testjava2025.infrastructure.persistance.PriceEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PriceEntityTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void testShouldPersistAndRetrievePriceEntity() {
        PriceEntity entity = new PriceEntity();
        entity.setRateId(99L);
        entity.setBrandId(1L);
        entity.setProductId(35455L);
        entity.setStartDateTime(LocalDateTime.of(2020, 6, 14, 0, 0));
        entity.setEndDateTime(LocalDateTime.of(2020, 6, 14, 23, 59));
        entity.setPriority(1);
        entity.setPrice(BigDecimal.valueOf(99.99));
        entity.setCurrency("EUR");

        testEntityManager.persistAndFlush(entity);

        PriceEntity found = testEntityManager.find(PriceEntity.class, entity.getRateId());
        assertThat(found).isNotNull();
        assertThat(found.getPrice()).isEqualByComparingTo("99.99");
    }
}
