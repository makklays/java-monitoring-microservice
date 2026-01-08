package com.techmatrix18.model;

import com.techmatrix18.enums.CardStatus;
import com.techmatrix18.enums.CardType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Entity representing card statistics.
 * Зачем: активность карт клиентов
 * Источник: TransactionCreatedEvent, CardBlockedEvent, CardUnblockedEvent
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 07.01.2026
 */
@Table(name = "card_statistics")
public class CardStatistic {

    @Id
    @Column("id")
    private Long id;

    @Column("date")
    private LocalDate date;              // дата в формате YYYY-MM-DD

    @Column("card_type")
    private CardType cardType;        // тип карты: DEBIT, CREDIT и т.д.

    @Column("status")
    private CardStatus status;        // ACTIVE, BLOCKED и т.д.

    @Column("transactions_count")
    private Integer transactionsCount; // количество транзакций

    @Column("total_spent")
    private Double totalSpent;        // общая сумма потраченных средств

    @Column("currency_code")
    private String currencyCode;      // код валюты в формате ISO 4217, например, EUR, USD, GBP и т.д.

    // --- Getters and Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public CardType getCardType() { return cardType; }
    public void setCardType(CardType cardType) { this.cardType = cardType; }

    public CardStatus getStatus() { return status; }
    public void setStatus(CardStatus status) { this.status = status; }

    public Integer getTransactionsCount() { return transactionsCount; }
    public void setTransactionsCount(Integer transactionsCount) { this.transactionsCount = transactionsCount; }

    public Double getTotalSpent() { return totalSpent; }
    public void setTotalSpent(Double totalSpent) { this.totalSpent = totalSpent; }

    public String getCurrencyCode() { return currencyCode; }
    public void setCurrencyCode(String currencyCode) { this.currencyCode = currencyCode; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardStatistic that)) return false;
        return Objects.equals(getId(), that.getId())
                && Objects.equals(getDate(), that.getDate())
                && Objects.equals(getCardType(), that.getCardType())
                && Objects.equals(getStatus(), that.getStatus())
                && Objects.equals(getTransactionsCount(), that.getTransactionsCount())
                && Objects.equals(getTotalSpent(), that.getTotalSpent())
                && Objects.equals(getCurrencyCode(), that.getCurrencyCode());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getCardType() != null ? getCardType().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getTransactionsCount() != null ? getTransactionsCount().hashCode() : 0);
        result = 31 * result + (getTotalSpent() != null ? getTotalSpent().hashCode() : 0);
        result = 31 * result + (getCurrencyCode() != null ? getCurrencyCode().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CardStatistic {" +
            "id=" + id +
            ", date='" + date + '\'' +
            ", cardType='" + cardType + '\'' +
            ", status='" + status + '\'' +
            ", transactionsCount=" + transactionsCount +
            ", totalSpent=" + totalSpent +
            ", currencyCode='" + currencyCode + '\'' +
            '}';
    }
}

