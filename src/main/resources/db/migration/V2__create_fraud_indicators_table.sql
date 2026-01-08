-- V2__create_fraud_indicators_table.sql
-- Migration #2: create table fraud_indicators

-- Creating table 'fraud_indicators' for saving main data of fraud_indicators
CREATE TABLE IF NOT EXISTS fraud_indicators (
    id               BIGSERIAL PRIMARY KEY,

    entity_type      VARCHAR(50) NOT NULL,      -- USER / CARD / ACCOUNT / MERCHANT
    entity_id        BIGINT NOT NULL,            -- ID сущности

    indicator_type   VARCHAR(100) NOT NULL,     -- HIGH_RISK_COUNTRY, MULTIPLE_CARDS и т.д.
    indicator_value  VARCHAR(255),               -- значение индикатора (страна, число, описание)

    created_at       TIMESTAMP(6) NOT NULL,     -- время создания (UTC)
    resolved         BOOLEAN NOT NULL DEFAULT FALSE
);

-- Создание индекса для быстрого поиска
CREATE INDEX idx_fraud_entity ON fraud_indicators(entity_type, entity_id);
CREATE INDEX idx_fraud_indicator_type ON fraud_indicators(indicator_type);
CREATE INDEX idx_fraud_created_at ON fraud_indicators(created_at);
CREATE INDEX idx_fraud_resolved ON fraud_indicators(resolved);

