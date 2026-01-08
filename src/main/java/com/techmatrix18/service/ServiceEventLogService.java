package com.techmatrix18.service;

import com.techmatrix18.model.ServiceEventLog;
import com.techmatrix18.repository.ServiceEventLogRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * Service for managing ServiceEventLog entities.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 08.01.2026
 */
@Service
public class ServiceEventLogService {
    private final ServiceEventLogRepository serviceEventLogRepo;

    public ServiceEventLogService(ServiceEventLogRepository serviceEventLogRepo) {
        this.serviceEventLogRepo = serviceEventLogRepo;
    }

    // Service methods for ServiceEventLog can be added here

    public Flux<ServiceEventLog> findAllByServiceName(String serviceName) {
        return serviceEventLogRepo.findAllByServiceName(serviceName);
    }

    public Flux<ServiceEventLog> findAllByEventType(String eventType) {
        return serviceEventLogRepo.findAllByEventType(eventType);
    }

    public Flux<ServiceEventLog> findAllByEntityType(String entityType) {
        return serviceEventLogRepo.findAllByEntityType(entityType);
    }

    public Flux<ServiceEventLog> findAllByEntityId(Long entityId) {
        return serviceEventLogRepo.findAllByEntityId(entityId);
    }

    public Flux<ServiceEventLog> findAllByEventTimeBetween(Long startEpochMillis, Long endEpochMillis) {
        return serviceEventLogRepo.findAllByEventTimeBetween(startEpochMillis, endEpochMillis);
    }

    public Flux<ServiceEventLog> findAllByServiceNameAndEventType(String serviceName, String eventType) {
        return serviceEventLogRepo.findAllByServiceNameAndEventType(serviceName, eventType);
    }

    public Flux<ServiceEventLog> findAllByServiceNameAndEventTypeAndEventTimeBetween(
            String serviceName,
            String eventType,
            Long startEpochMillis,
            Long endEpochMillis
    ) {
        return serviceEventLogRepo.findAllByServiceNameAndEventTypeAndEventTimeBetween(
                serviceName,
                eventType,
                startEpochMillis,
                endEpochMillis
        );
    }
}

