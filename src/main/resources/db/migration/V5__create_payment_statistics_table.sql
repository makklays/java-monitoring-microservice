-- V5__create_payment_statistics_table.sql
-- Migration #5: create table payment_statistics

-- Creating table 'payment_statistics' for saving main data of payment_statistics
CREATE TABLE IF NOT EXISTS payment_statistics (
    id              BIGSERIAL PRIMARY KEY,

    date            DATE NOT NULL,                 -- бизнес-дата (YYYY-MM-DD)

    payment_type    VARCHAR(50) NOT NULL,          -- SEPA, BIZUM, INTERNAL и т.д.
    status          VARCHAR(50) NOT NULL,          -- COMPLETED, PENDING, FAILED

    currency_code   VARCHAR(10) NOT NULL,              -- ISO 4217 (EUR, USD, GBP)

    total_count     INTEGER NOT NULL DEFAULT 0,    -- количество платежей
    total_amount    NUMERIC(19, 4) NOT NULL DEFAULT 0 -- общая сумма
);

-- Основной аналитический индекс
CREATE INDEX idx_payment_statistics_date_type_status ON payment_statistics(date, payment_type, status);

-- Часто используемый фильтр по валюте
CREATE INDEX idx_payment_statistics_currency ON payment_statistics(currency_code);

