-- V6__create_service_event_log_table.sql
-- Migration #6: create table service_event_log

-- Creating table 'service_event_log' for saving main data of service_event_log
CREATE TABLE IF NOT EXISTS service_event_log (
    id            BIGSERIAL PRIMARY KEY,

    service_name  VARCHAR(100) NOT NULL,      -- источник события
    event_type    VARCHAR(50) NOT NULL,       -- PAYMENT_CREATED, CARD_BLOCKED и т.д.
    entity_type   VARCHAR(50) NOT NULL,       -- Payment, CreditCard и т.д.

    entity_id     BIGINT NOT NULL,             -- id сущности
    event_time    TIMESTAMP(6) NOT NULL,       -- время события (UTC)
    payload       TEXT                         -- Дополнительные данные события (JSON или текст)
);

-- Быстрый поиск событий по времени
CREATE INDEX idx_service_event_log_event_time ON service_event_log(event_time DESC);

-- По сущности
CREATE INDEX idx_service_event_log_entity ON service_event_log(entity_type, entity_id);

-- По типу события
CREATE INDEX idx_service_event_log_event_type ON service_event_log(event_type);

