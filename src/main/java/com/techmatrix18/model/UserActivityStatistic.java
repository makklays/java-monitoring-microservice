package com.techmatrix18.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Entity representing user activity statistics.
 * Зачем: поведение пользователей в приложении
 * Используется для:
 *   сегментации
 *   риск-аналитики
 *   персонализации
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 07.01.2026
 */
@Table(name = "user_activity_statistics")
public class UserActivityStatistic {

    @Id
    @Column("id")
    private Long id;

    @Column("date")
    private LocalDate date;           // дата в формате YYYY-MM-DD

    @Column("user_id")
    private Long userId;              // идентификатор пользователя

    @Column("payments_count")
    private Integer paymentsCount;    // количество платежей

    @Column("cards_count")
    private Integer cardsCount;        // количество карт

    @Column("total_amount")
    private BigDecimal totalAmount;       // общая сумма операций

    @Column("last_activity_at")
    private LocalDateTime lastActivityAt;      // время последней активности в формате epoch milliseconds

    // --- Getters and Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Integer getPaymentsCount() { return paymentsCount; }
    public void setPaymentsCount(Integer paymentsCount) { this.paymentsCount = paymentsCount; }

    public Integer getCardsCount() { return cardsCount; }
    public void setCardsCount(Integer cardsCount) { this.cardsCount = cardsCount; }

    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }

    public LocalDateTime getLastActivityAt() { return lastActivityAt; }
    public void setLastActivityAt(LocalDateTime lastActivityAt) { this.lastActivityAt = lastActivityAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserActivityStatistic that)) return false;
        return getId().equals(that.getId()) && getDate().equals(that.getDate()) &&
            getUserId().equals(that.getUserId()) && getPaymentsCount().equals(that.getPaymentsCount()) &&
            getCardsCount().equals(that.getCardsCount()) && getTotalAmount().equals(that.getTotalAmount()) &&
            Objects.equals(getLastActivityAt(), that.getLastActivityAt());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
        result = 31 * result + (getPaymentsCount() != null ? getPaymentsCount().hashCode() : 0);
        result = 31 * result + (getCardsCount() != null ? getCardsCount().hashCode() : 0);
        result = 31 * result + (getTotalAmount() != null ? getTotalAmount().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserActivityStatistic {" +
            "id=" + id +
            ", date='" + date + '\'' +
            ", userId=" + userId +
            ", paymentsCount=" + paymentsCount +
            ", cardsCount=" + cardsCount +
            ", totalAmount=" + totalAmount +
            ", lastActivityAt=" + lastActivityAt +
            '}';
    }
}

