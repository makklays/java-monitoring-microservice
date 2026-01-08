-- V3__create_integration_failures_table.sql
-- Migration #3: create table integration_failures

-- Creating table 'integration_failures' for saving main data of integration_failures
CREATE TABLE IF NOT EXISTS integration_failures (
    id               BIGSERIAL PRIMARY KEY,

    source_service   VARCHAR(100) NOT NULL,     -- сервис-источник
    target_service   VARCHAR(100) NOT NULL,     -- сервис-получатель

    operation        VARCHAR(50) NOT NULL,      -- CREATE / UPDATE / DELETE и т.д.
    error_code       VARCHAR(100),               -- код ошибки

    occurred_at      TIMESTAMP(6) NOT NULL,     -- время возникновения ошибки (UTC)
    resolved         BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE INDEX idx_integration_failures_services
    ON integration_failures(source_service, target_service);

CREATE INDEX idx_integration_failures_operation
    ON integration_failures(operation);

CREATE INDEX idx_integration_failures_occurred_at
    ON integration_failures(occurred_at);

CREATE INDEX idx_integration_failures_resolved
    ON integration_failures(resolved);

