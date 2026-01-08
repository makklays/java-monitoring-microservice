package com.techmatrix18.model;

import com.techmatrix18.enums.OperationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * Entity representing integration failures between services.
 * Зачем: видеть проблемы между сервисами и быстро их решать (важно для стабильности системы)
 * Очень любят SRE + архитекторы :)
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 07.01.2026
 */
@Table(name = "integration_failures")
public class IntegrationFailure {

    @Id
    @Column("id")
    private Long id;

    @Column("source_service")
    private String sourceService;      // название сервиса-источника

    @Column("target_service")
    private String targetService;      // название сервиса-получателя

    @Column("operation")
    private OperationType operation;          // тип операции: CREATE, UPDATE, DELETE и т.д.

    @Column("error_code")
    private String errorCode;          // код ошибки интеграции

    @Column("occurred_at")
    private LocalDateTime occurredAt;  // время возникновения ошибки в формате epoch milliseconds

    @Column("resolved")
    private Boolean resolved;          // флаг, указывающий, была ли ошибка разрешена

    // --- Getters and Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSourceService() { return sourceService; }
    public void setSourceService(String sourceService) { this.sourceService = sourceService; }

    public String getTargetService() { return targetService; }
    public void setTargetService(String targetService) { this.targetService = targetService; }

    public OperationType getOperation() { return operation; }
    public void setOperation(OperationType operation) { this.operation = operation; }

    public String getErrorCode() { return errorCode; }
    public void setErrorCode(String errorCode) { this.errorCode = errorCode; }

    public LocalDateTime getOccurredAt() { return occurredAt; }
    public void setOccurredAt(LocalDateTime occurredAt) { this.occurredAt = occurredAt; }

    public Boolean getResolved() { return resolved; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntegrationFailure that)) return false;
        return getId().equals(that.getId()) && getSourceService().equals(that.getSourceService()) &&
            getTargetService().equals(that.getTargetService()) && getOperation().equals(that.getOperation()) &&
            getErrorCode().equals(that.getErrorCode()) && getOccurredAt().equals(that.getOccurredAt()) &&
            getResolved().equals(that.getResolved());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getSourceService() != null ? getSourceService().hashCode() : 0);
        result = 31 * result + (getTargetService() != null ? getTargetService().hashCode() : 0);
        result = 31 * result + (getOperation() != null ? getOperation().hashCode() : 0);
        result = 31 * result + (getErrorCode() != null ? getErrorCode().hashCode() : 0);
        result = 31 * result + (getOccurredAt() != null ? getOccurredAt().hashCode() : 0);
        result = 31 * result + (getResolved() != null ? getResolved().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "IntegrationFailure {" +
            "id=" + id +
            ", sourceService='" + sourceService + '\'' +
            ", targetService='" + targetService + '\'' +
            ", operation='" + operation + '\'' +
            ", errorCode='" + errorCode + '\'' +
            ", occurredAt=" + occurredAt +
            ", resolved=" + resolved +
            '}';
    }
}

