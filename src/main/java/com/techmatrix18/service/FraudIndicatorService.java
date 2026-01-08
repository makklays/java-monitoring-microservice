package com.techmatrix18.service;

import com.techmatrix18.model.FraudIndicator;
import com.techmatrix18.repository.FraudIndicatorRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * Service for managing FraudIndicator entities.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 08.01.2026
 */
@Service
public class FraudIndicatorService {
    private final FraudIndicatorRepository fraudIndicatorRepo;

    public FraudIndicatorService(FraudIndicatorRepository fraudIndicatorRepo) {
        this.fraudIndicatorRepo = fraudIndicatorRepo;
    }

    // Service methods for FraudIndicator can be added here

    public Flux<FraudIndicator> findAllByEntityType(String entityType) {
        return fraudIndicatorRepo.findAllByEntityType(entityType);
    }

    public Flux<FraudIndicator> findAllByEntityId(Long entityId) {
        return fraudIndicatorRepo.findAllByEntityId(entityId);
    }

    public Flux<FraudIndicator> findAllByIndicatorType(String indicatorType) {
        return fraudIndicatorRepo.findAllByIndicatorType(indicatorType);
    }

    public Flux<FraudIndicator> findAllByResolvedFalse() {
        return fraudIndicatorRepo.findAllByResolvedFalse();
    }

    public Flux<FraudIndicator> findAllByCreatedAtBetween(Long startEpochMillis, Long endEpochMillis) {
        return fraudIndicatorRepo.findAllByCreatedAtBetween(startEpochMillis, endEpochMillis);
    }

    public Flux<FraudIndicator> findAllByEntityTypeAndEntityId(String entityType, Long entityId) {
        return fraudIndicatorRepo.findAllByEntityTypeAndEntityId(entityType, entityId);
    }

    public Flux<FraudIndicator> findAllByIndicatorTypeAndResolved(String indicatorType, Boolean resolved) {
        return fraudIndicatorRepo.findAllByIndicatorTypeAndResolved(indicatorType, resolved);
    }
}

