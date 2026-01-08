package com.techmatrix18.model;

import com.techmatrix18.enums.PaymentStatus;
import com.techmatrix18.enums.PaymentType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entity representing payment statistics.
 * Зачем: мониторинг платежей и переводов в системе
 * Источник: PaymentCompletedEvent, PaymentFailedEvent
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 07.01.2026
 */
@Table(name = "payment_statistics")
public class PaymentStatistic {

    @Id
    @Column("id")
    private Long id;

    @Column("date")
    private LocalDate date;           // дата в формате YYYY-MM-DD

    @Column("payment_type")
    private PaymentType paymentType;  // тип платежа: SEPA, BIZUM, INTERNAL и т.д.

    @Column("status")
    private PaymentStatus status;     // SUCCESS / FAILED - статус платежа: COMPLETED, PENDING, FAILED и т.д.

    @Column("currency_code")
    private String currencyCode;      // код валюты в формате ISO 4217, например, EUR, USD, GBP и т.д.

    @Column("total_count")
    private Integer totalCount;    // количество

    @Column("total_amount")
    private BigDecimal totalAmount;   // сумма

    // --- Getters and Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public PaymentType getPaymentType() { return paymentType; }
    public void setPaymentType(PaymentType paymentType) { this.paymentType = paymentType; }

    public PaymentStatus getStatus() { return status; }
    public void setStatus(PaymentStatus status) { this.status = status; }

    public String getCurrencyCode() { return currencyCode; }
    public void setCurrencyCode(String currencyCode) { this.currencyCode = currencyCode; }

    public Integer getTotalCount() { return totalCount; }
    public void setTotalCount(Integer totalCount) { this.totalCount = totalCount; }

    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentStatistic that)) return false;
        return getId().equals(that.getId()) && getDate().equals(that.getDate()) &&
            getPaymentType().equals(that.getPaymentType()) && getStatus().equals(that.getStatus()) &&
            getCurrencyCode().equals(that.getCurrencyCode()) && getTotalCount().equals(that.getTotalCount()) &&
            getTotalAmount().equals(that.getTotalAmount());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getPaymentType() != null ? getPaymentType().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getCurrencyCode() != null ? getCurrencyCode().hashCode() : 0);
        result = 31 * result + (getTotalCount() != null ? getTotalCount().hashCode() : 0);
        result = 31 * result + (getTotalAmount() != null ? getTotalAmount().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PaymentStatistic {" +
            "id=" + id +
            ", date=" + date +
            ", paymentType='" + paymentType + '\'' +
            ", status='" + status + '\'' +
            ", currencyCode='" + currencyCode + '\'' +
            ", totalCount=" + totalCount +
            ", totalAmount=" + totalAmount +
            '}';
    }
}

