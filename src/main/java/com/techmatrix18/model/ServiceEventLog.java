package com.techmatrix18.model;

import com.techmatrix18.enums.ServiceEntityType;
import com.techmatrix18.enums.ServiceEventType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * Entity representing a log of service events.
 * Зачем: аудит и трассировка бизнес-событий между микросервисами
 * Используется для:
 *   отладки
 *   расследований
 *   бизнес-аудита
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 07.01.2026
 */
@Table(name = "service_event_log")
public class ServiceEventLog {

    @Id
    @Column("id")
    private Long id;

    @Column("service_name")
    private String serviceName;              // источник события

    @Column("event_type")
    private ServiceEventType eventType;      // PAYMENT_CREATED, CARD_BLOCKED и т.д.

    @Column("entity_type")
    private ServiceEntityType entityType;    // Payment, CreditCard и т.д.

    @Column("entity_id")
    private Long entityId;                   // id сущности, к которой относится событие

    @Column("event_time")
    private LocalDateTime eventTime;                  // когда произошло - время события в формате epoch milliseconds

    @Column("payload")
    private String payload;                  // дополнительная информация в формате JSON

    // --- Getters and Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }

    public ServiceEventType getEventType() { return eventType; }
    public void setEventType(ServiceEventType eventType) { this.eventType = eventType; }

    public ServiceEntityType getEntityType() { return entityType; }
    public void setEntityType(ServiceEntityType entityType) { this.entityType = entityType; }

    public Long getEntityId() { return entityId; }
    public void setEntityId(Long entityId) { this.entityId = entityId; }

    public LocalDateTime getEventTime() { return eventTime; }
    public void setEventTime(LocalDateTime eventTime) { this.eventTime = eventTime; }

    public String getPayload() { return payload; }
    public void setPayload(String payload) { this.payload = payload; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceEventLog that)) return false;
        return getId().equals(that.getId()) && getServiceName().equals(that.getServiceName()) &&
            getEventType().equals(that.getEventType()) && getEntityType().equals(that.getEntityType()) &&
            getEntityId().equals(that.getEntityId()) && getEventTime().equals(that.getEventTime()) &&
            getPayload().equals(that.getPayload());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getServiceName() != null ? getServiceName().hashCode() : 0);
        result = 31 * result + (getEventType() != null ? getEventType().hashCode() : 0);
        result = 31 * result + (getEntityType() != null ? getEntityType().hashCode() : 0);
        result = 31 * result + (getEntityId() != null ? getEntityId().hashCode() : 0);
        result = 31 * result + (getEventTime() != null ? getEventTime().hashCode() : 0);
        result = 31 * result + (getPayload() != null ? getPayload().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ServiceEventLog {" +
            "id=" + id +
            ", serviceName='" + serviceName + '\'' +
            ", eventType='" + eventType + '\'' +
            ", entityType='" + entityType + '\'' +
            ", entityId=" + entityId +
            ", eventTime=" + eventTime +
            ", payload='" + payload + '\'' +
            '}';
    }
}

