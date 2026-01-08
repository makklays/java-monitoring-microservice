package com.techmatrix18.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entity representing merchant statistics.
 * Зачем: аналитика мерчантов (очень важно для банка)
 * Источник: TransactionCompletedEvent и другие события, связанные с торговцами
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 07.01.2026
 */
@Table(name = "merchant_statistics")
public class MerchantStatistic {

    @Id
    @Column("id")
    private Long id;

    @Column("merchant_id")
    private Long merchantId;          // идентификатор торговца

    @Column("date")
    private LocalDate date;           // дата в формате YYYY-MM-DD

    @Column("category")
    private String category;          // категория товаров или услуг

    @Column("transactions_count")
    private Integer transactionsCount; // количество транзакций

    @Column("total_amount")
    private BigDecimal totalAmount;       // общая сумма транзакций

    @Column("average_ticket")
    private BigDecimal averageTicket;     // средний чек

    // --- Getters and Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getMerchantId() { return merchantId; }
    public void setMerchantId(Long merchantId) { this.merchantId = merchantId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Integer getTransactionsCount() { return transactionsCount; }
    public void setTransactionsCount(Integer transactionsCount) { this.transactionsCount = transactionsCount; }

    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }

    public BigDecimal getAverageTicket() { return averageTicket; }
    public void setAverageTicket(BigDecimal averageTicket) { this.averageTicket = averageTicket; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MerchantStatistic that)) return false;
        return getId().equals(that.getId()) && getMerchantId().equals(that.getMerchantId()) &&
            getDate().equals(that.getDate()) && getCategory().equals(that.getCategory()) &&
            getTransactionsCount().equals(that.getTransactionsCount()) &&
            getTotalAmount().equals(that.getTotalAmount()) && getAverageTicket().equals(that.getAverageTicket());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getMerchantId() != null ? getMerchantId().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        result = 31 * result + (getTransactionsCount() != null ? getTransactionsCount().hashCode() : 0);
        result = 31 * result + (getTotalAmount() != null ? getTotalAmount().hashCode() : 0);
        result = 31 * result + (getAverageTicket() != null ? getAverageTicket().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MerchantStatistic {" +
            "id=" + id +
            ", merchantId=" + merchantId +
            ", date='" + date + '\'' +
            ", category='" + category + '\'' +
            ", transactionsCount=" + transactionsCount +
            ", totalAmount=" + totalAmount +
            ", averageTicket=" + averageTicket +
            '}';
    }
}

