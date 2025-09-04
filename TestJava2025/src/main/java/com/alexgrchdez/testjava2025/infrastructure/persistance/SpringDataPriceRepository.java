package com.alexgrchdez.testjava2025.infrastructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface SpringDataPriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query("""
            SELECT price FROM PriceEntity price
            WHERE price.productId = :productId
            AND price.brandId = :brandId
            AND :applyDate BETWEEN price.startDateTime AND price.endDateTime
            ORDER BY price.priority DESC""")
    List<PriceEntity> findApplicableRate(@Param("productId") Long productId, @Param("brandId") Long brandId, @Param("applyDate") LocalDateTime applicationDate);
}
