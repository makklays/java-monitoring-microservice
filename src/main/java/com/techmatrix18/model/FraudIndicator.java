package com.techmatrix18.model;

import com.techmatrix18.enums.FraudIndicatorEntityType;
import com.techmatrix18.enums.FraudIndicatorType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * Entity representing fraud indicators.
 * Зачем: early fraud detection (не engine, а сигналы) для скоринга транзакций
 * Используется:
 *   Risk team
 *   manual review
 *   алерты
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 07.01.2026
 */
@Table(name = "fraud_indicators")
public class FraudIndicator {

    @Id
    @Column("id")
    private Long id;

    @Column("entity_type")
    private FraudIndicatorEntityType entityType; // USER / CARD / ACCOUNT - тип сущности: User, Card, Merchant и т.д.

    @Column("entity_id")
    private Long entityId;                       // идентификатор сущности

    @Column("indicator_type")
    private FraudIndicatorType indicatorType;    // тип индикатора мошенничества: HIGH_RISK_COUNTRY, MULTIPLE_CARDS и т.д.

    @Column("indicator_value")
    private String indicatorValue;               // значение индикатора мошенничества: страна, количество и т.д.

    @Column("created_at")
    private LocalDateTime createdAt;                      // время создания индикатора в формате epoch milliseconds

    @Column("resolved")
    private Boolean resolved;                    // флаг, указывающий, был ли индикатор разрешен

    // --- Getters and Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public FraudIndicatorEntityType getEntityType() { return entityType; }
    public void setEntityType(FraudIndicatorEntityType entityType) { this.entityType = entityType; }

    public Long getEntityId() { return entityId; }
    public void setEntityId(Long entityId) { this.entityId = entityId; }

    public FraudIndicatorType getIndicatorType() { return indicatorType; }
    public void setIndicatorType(FraudIndicatorType indicatorType) { this.indicatorType = indicatorType; }

    public String getIndicatorValue() { return indicatorValue; }
    public void setIndicatorValue(String indicatorValue) { this.indicatorValue = indicatorValue; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public Boolean getResolved() { return resolved; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FraudIndicator that)) return false;
        return getId().equals(that.getId()) && getEntityType().equals(that.getEntityType()) &&
            getEntityId().equals(that.getEntityId()) && getIndicatorType().equals(that.getIndicatorType()) &&
            getIndicatorValue().equals(that.getIndicatorValue()) && getResolved().equals(that.getResolved());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getEntityType() != null ? getEntityType().hashCode() : 0);
        result = 31 * result + (getEntityId() != null ? getEntityId().hashCode() : 0);
        result = 31 * result + (getIndicatorType() != null ? getIndicatorType().hashCode() : 0);
        result = 31 * result + (getIndicatorValue() != null ? getIndicatorValue().hashCode() : 0);
        result = 31 * result + (getResolved() != null ? getResolved().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FraudIndicator {" +
            "id=" + id +
            ", entityType='" + entityType + '\'' +
            ", entityId=" + entityId +
            ", indicatorType='" + indicatorType + '\'' +
            ", indicatorValue='" + indicatorValue + '\'' +
            ", createdAt=" + createdAt +
            ", resolved=" + resolved +
            '}';
    }
}

