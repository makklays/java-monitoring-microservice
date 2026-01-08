-- V8__create_user_activity_statistics_table.sql
-- Migration #8: create table user_activity_statistics

-- Creating table 'user_activity_statistics' for saving main data of user_activity_statistics
CREATE TABLE IF NOT EXISTS user_activity_statistics (
    id               BIGSERIAL PRIMARY KEY,      -- Автоинкрементный первичный ключ
    date             DATE NOT NULL,              -- дата статистики (YYYY-MM-DD)
    user_id          BIGINT NOT NULL,            -- идентификатор пользователя
    payments_count   INTEGER DEFAULT 0,          -- количество платежей
    cards_count      INTEGER DEFAULT 0,          -- количество карт
    total_amount     NUMERIC(19,4) DEFAULT 0,    -- общая сумма операций
    last_activity_at TIMESTAMP(6)                -- время последней активности (с микросекундами)
);

-- Быстрые выборки по пользователю
CREATE INDEX idx_user_activity_statistics_user ON user_activity_statistics(user_id);

-- Быстрые выборки по дате
CREATE INDEX idx_user_activity_statistics_date ON user_activity_statistics(date);

-- Уникальность: один пользователь — одна запись на день
CREATE UNIQUE INDEX ux_user_activity_user_date ON user_activity_statistics(user_id, date);

