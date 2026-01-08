-- V4__create_merchant_statistics_table.sql
-- Migration #4: create table merchant_statistics

-- Creating table 'merchant_statistics' for saving main data of merchant_statistics
CREATE TABLE IF NOT EXISTS merchant_statistics (
    id                  BIGSERIAL PRIMARY KEY,

    merchant_id         BIGINT NOT NULL,          -- идентификатор торговца
    date                DATE NOT NULL,            -- бизнес-дата (YYYY-MM-DD)

    category            VARCHAR(100) NOT NULL,    -- категория товаров / услуг

    transactions_count  INTEGER NOT NULL DEFAULT 0,   -- количество транзакций
    total_amount        NUMERIC(19, 4) NOT NULL DEFAULT 0, -- общая сумма
    average_ticket      NUMERIC(19, 4)             -- средний чек
);

-- Часто используется в отчётах
CREATE INDEX idx_merchant_statistics_merchant_date ON merchant_statistics(merchant_id, date);

-- Фильтрация по дате
CREATE INDEX idx_merchant_statistics_date ON merchant_statistics(date);

-- Категорийная аналитика
CREATE INDEX idx_merchant_statistics_category ON merchant_statistics(category);

