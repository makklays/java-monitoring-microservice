-- V1__create_card_statistics_table.sql
-- Migration #1: create table card_statistics

-- Creating table 'card_statistics' for saving main data of card_statistics
CREATE TABLE IF NOT EXISTS card_statistics (
    id                  BIGSERIAL PRIMARY KEY,
    date                DATE NOT NULL,                 -- YYYY-MM-DD (без времени и таймзоны)

    card_type           VARCHAR(50) NOT NULL,          -- DEBIT, CREDIT и т.д.
    status              VARCHAR(50) NOT NULL,          -- ACTIVE, BLOCKED и т.д.

    transactions_count  INTEGER,                       -- количество транзакций
    total_spent         NUMERIC(18, 2),                -- денежная сумма (лучше, чем DOUBLE)
    currency_code       VARCHAR(10) NOT NULL            -- ISO 4217: EUR, USD и т.д.
);

-- Создание уникального индекса для предотвращения дублирования записей по дате, типу карты и статусу
CREATE INDEX idx_card_statistics_date ON card_statistics(date);
CREATE INDEX idx_card_statistics_card_type ON card_statistics(card_type);
CREATE INDEX idx_card_statistics_status ON card_statistics(status);

