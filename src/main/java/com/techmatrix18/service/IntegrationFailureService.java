package com.techmatrix18.service;

import com.techmatrix18.model.IntegrationFailure;
import com.techmatrix18.repository.IntegrationFailureRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

/**
 * Service for managing IntegrationFailure entities.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 08.01.2026
 */
@Service
public class IntegrationFailureService {
    private final IntegrationFailureRepository integrationFailureRepo;

    public IntegrationFailureService(IntegrationFailureRepository integrationFailureRepo) {
        this.integrationFailureRepo = integrationFailureRepo;
    }

    // Service methods for IntegrationFailure can be added here

    public Flux<IntegrationFailure> findAllBySourceService(String sourceService) {
        return integrationFailureRepo.findAllBySourceService(sourceService);
    }

    public Flux<IntegrationFailure> findAllByTargetService(String targetService) {
        return integrationFailureRepo.findAllByTargetService(targetService);
    }

    public Flux<IntegrationFailure> findAllByOperation(String operation) {
        return integrationFailureRepo.findAllByOperation(operation);
    }

    public Flux<IntegrationFailure> findAllByErrorCode(String errorCode) {
        return integrationFailureRepo.findAllByErrorCode(errorCode);
    }

    public Flux<IntegrationFailure> findAllByOccurredAtBetween(LocalDateTime start, LocalDateTime end) {
        return integrationFailureRepo.findAllByOccurredAtBetween(start, end);
    }

    public Flux<IntegrationFailure> findAllByResolvedFalse() {
        return integrationFailureRepo.findAllByResolvedFalse();
    }

    public Flux<IntegrationFailure> findAllBySourceServiceAndTargetServiceAndOperationAndResolved(
            String sourceService,
            String targetService,
            String operation,
            Boolean resolved
    ) {
        return integrationFailureRepo.findAllBySourceServiceAndTargetServiceAndOperationAndResolved(
                sourceService,
                targetService,
                operation,
                resolved
        );
    }
}

