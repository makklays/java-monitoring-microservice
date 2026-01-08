-- V7__create_system_business_kpis_table.sql
-- Migration #7: create table system_business_kpis

-- Creating table 'system_business_kpis' for saving main data of system_business_kpis
CREATE TABLE IF NOT EXISTS system_business_kpis (
    id             BIGSERIAL PRIMARY KEY,
    date           DATE NOT NULL,              -- дата KPI (YYYY-MM-DD)
    metric_name    VARCHAR(100) NOT NULL,      -- название метрики
    metric_value   DOUBLE PRECISION NOT NULL,  -- значение метрики
    currency_code  VARCHAR(10)                 -- ISO 4217 (EUR, USD и т.д.)
);

-- Основные выборки по дате
CREATE INDEX idx_system_business_kpis_date ON system_business_kpis(date);

-- По метрике
CREATE INDEX idx_system_business_kpis_metric_name ON system_business_kpis(metric_name);

-- Уникальность KPI за день (очень важно)
CREATE UNIQUE INDEX ux_system_business_kpis_day_metric_currency
    ON system_business_kpis(date, metric_name, currency_code);

