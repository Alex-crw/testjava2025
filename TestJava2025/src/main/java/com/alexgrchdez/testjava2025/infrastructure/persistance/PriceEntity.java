package com.alexgrchdez.testjava2025.infrastructure.persistance;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="prices")
public class PriceEntity {

    @Id
    @Column(name="rate_id")
    private Long rateId;
    @Column(name="brand_id")
    private Long brandId;
    @Column(name="product_id")
    private Long productId;
    @Column(name="start_date_time")
    private LocalDateTime startDateTime;
    @Column(name="end_date_time")
    private LocalDateTime endDateTime;
    private Integer priority;
    private BigDecimal price;
    private String currency;

    public PriceEntity(Long rateId, Long brandId, Long productId, LocalDateTime startDateTime, Integer priority, LocalDateTime endDateTime, BigDecimal price, String currency) {
        this.rateId = rateId;
        this.brandId = brandId;
        this.productId = productId;
        this.startDateTime = startDateTime;
        this.priority = priority;
        this.endDateTime = endDateTime;
        this.price = price;
        this.currency = currency;
    }

    public PriceEntity() {

    }

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
