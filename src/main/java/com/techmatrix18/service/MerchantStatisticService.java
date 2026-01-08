package com.techmatrix18.service;

import com.techmatrix18.model.CardStatistic;
import com.techmatrix18.model.MerchantStatistic;
import com.techmatrix18.repository.MerchantStatisticRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

/**
 * Service for managing MerchantStatistic entities.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 08.01.2026
 */
@Service
public class MerchantStatisticService {
    private final MerchantStatisticRepository merchantStatisticRepo;

    public MerchantStatisticService(MerchantStatisticRepository merchantStatisticRepo) {
        this.merchantStatisticRepo = merchantStatisticRepo;
    }

    // Service methods for MerchantStatistic can be added here

    public Flux<MerchantStatistic> findAll() {
        return merchantStatisticRepo.findAll();
    }

    public Flux<MerchantStatistic> findAllByMerchantId(Long merchantId) {
        return merchantStatisticRepo.findAllByMerchantId(merchantId);
    }

    public Flux<MerchantStatistic> findAllByDate(LocalDate date) {
        return merchantStatisticRepo.findAllByDate(date);
    }

    public Flux<MerchantStatistic> findAllByDateBetween(LocalDate startDate, LocalDate endDate) {
        return merchantStatisticRepo.findAllByDateBetween(startDate, endDate);
    }

    public Flux<MerchantStatistic> findAllByCategory(String category) {
        return merchantStatisticRepo.findAllByCategory(category);
    }

    public Flux<MerchantStatistic> findAllByMerchantIdAndDate(Long merchantId, LocalDate date) {
        return merchantStatisticRepo.findAllByMerchantIdAndDate(merchantId, date);
    }

    public Flux<MerchantStatistic> findAllByMerchantIdAndDateAndCategory(Long merchantId, LocalDate date, String category) {
        return merchantStatisticRepo.findAllByMerchantIdAndDateAndCategory(merchantId, date, category);
    }
}

