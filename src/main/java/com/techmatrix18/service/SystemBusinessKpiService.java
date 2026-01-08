package com.techmatrix18.service;

import com.techmatrix18.model.SystemBusinessKpi;
import com.techmatrix18.repository.SystemBusinessKpiRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

/**
 * Service for managing SystemBusinessKpi entities.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 08.01.2026
 */
@Service
public class SystemBusinessKpiService {
    private final SystemBusinessKpiRepository systemBusinessKpiRepo;

    public SystemBusinessKpiService(SystemBusinessKpiRepository systemBusinessKpiRepo) {
        this.systemBusinessKpiRepo = systemBusinessKpiRepo;
    }

    // Service methods for SystemBusinessKpi can be added here

    public Flux<SystemBusinessKpi> findAllByDate(LocalDate date) {
        return systemBusinessKpiRepo.findAllByDate(date);
    }

    public Flux<SystemBusinessKpi> findAllByDateBetween(LocalDate startDate, LocalDate endDate) {
        return systemBusinessKpiRepo.findAllByDateBetween(startDate, endDate);
    }

    public Flux<SystemBusinessKpi> findAllByMetricName(String metricName) {
        return systemBusinessKpiRepo.findAllByMetricName(metricName);
    }

    public Flux<SystemBusinessKpi> findAllByCurrencyCode(String currencyCode) {
        return systemBusinessKpiRepo.findAllByCurrencyCode(currencyCode);
    }

    public Flux<SystemBusinessKpi> findAllByDateAndMetricName(LocalDate date, String metricName) {
        return systemBusinessKpiRepo.findAllByDateAndMetricName(date, metricName);
    }

    public Flux<SystemBusinessKpi> findAllByDateAndMetricNameAndCurrencyCode(
        LocalDate date,
        String metricName,
        String currencyCode
    ) {
        return systemBusinessKpiRepo.findAllByDateAndMetricNameAndCurrencyCode(date, metricName, currencyCode);
    }
}

