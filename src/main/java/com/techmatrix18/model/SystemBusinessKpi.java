package com.techmatrix18.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

/**
 * Entity representing system business KPIs.
 * Зачем: executive dashboard для мониторинга ключевых показателей бизнеса в реальном времени
 * KPI:
 *   Total volume
 *   Success rate
 *   Avg transaction amount
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 07.01.2026
 */
@Table(name = "system_business_kpis")
public class SystemBusinessKpi {

    @Id
    @Column("id")
    private Long id;

    @Column("date")
    private LocalDate date;             // дата в формате YYYY-MM-DD

    @Column("metric_name")
    private String metricName;          // название метрики

    @Column("metric_value")
    private Double metricValue;        // значение метрики

    @Column("currency_code")
    private String currencyCode;       // код валюты в формате ISO 4217, например, EUR, USD, GBP и т.д.

    // --- Getters and Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getMetricName() { return metricName; }
    public void setMetricName(String metricName) { this.metricName = metricName; }

    public Double getMetricValue() { return metricValue; }
    public void setMetricValue(Double metricValue) { this.metricValue = metricValue; }

    public String getCurrencyCode() { return currencyCode; }
    public void setCurrencyCode(String currencyCode) { this.currencyCode = currencyCode; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SystemBusinessKpi that)) return false;
        return getId().equals(that.getId()) && getDate().equals(that.getDate()) &&
            getMetricName().equals(that.getMetricName()) && getMetricValue().equals(that.getMetricValue()) &&
            getCurrencyCode().equals(that.getCurrencyCode());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getMetricName() != null ? getMetricName().hashCode() : 0);
        result = 31 * result + (getMetricValue() != null ? getMetricValue().hashCode() : 0);
        result = 31 * result + (getCurrencyCode() != null ? getCurrencyCode().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SystemBusinessKpi {" +
            "id=" + id +
            ", date=" + date +
            ", metricName='" + metricName + '\'' +
            ", metricValue=" + metricValue +
            ", currencyCode='" + currencyCode + '\'' +
            '}';
    }
}

