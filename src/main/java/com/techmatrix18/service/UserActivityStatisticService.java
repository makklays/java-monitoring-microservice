package com.techmatrix18.service;

import com.techmatrix18.model.UserActivityStatistic;
import com.techmatrix18.repository.UserActivityStatisticRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

/**
 * Service for managing UserActivityStatistic entities.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 08.01.2026
 */
@Service
public class UserActivityStatisticService {
    private final UserActivityStatisticRepository userActivityStatisticRepo;

    public UserActivityStatisticService(UserActivityStatisticRepository userActivityStatisticRepo) {
        this.userActivityStatisticRepo = userActivityStatisticRepo;
    }

    // Service methods for UserActivityStatistic can be added here

    public Flux<UserActivityStatistic> findAllByUserId(Long userId) {
        return userActivityStatisticRepo.findAllByUserId(userId);
    }

    public Flux<UserActivityStatistic> findAllByDate(LocalDate date) {
        return userActivityStatisticRepo.findAllByDate(date);
    }

    public Flux<UserActivityStatistic> findAllByDateBetween(LocalDate startDate, LocalDate endDate) {
        return userActivityStatisticRepo.findAllByDateBetween(startDate, endDate);
    }

    public Flux<UserActivityStatistic> findAllByPaymentsCountGreaterThan(Double paymentsCount) {
        return userActivityStatisticRepo.findAllByPaymentsCountGreaterThan(paymentsCount);
    }

    public Flux<UserActivityStatistic> findAllByCardsCountGreaterThan(Double cardsCount) {
        return userActivityStatisticRepo.findAllByCardsCountGreaterThan(cardsCount);
    }

    public Flux<UserActivityStatistic> findAllByTotalAmountGreaterThan(Double totalAmount) {
        return userActivityStatisticRepo.findAllByTotalAmountGreaterThan(totalAmount);
    }

    public Flux<UserActivityStatistic> findAllByUserIdAndDate(Long userId, LocalDate date) {
        return userActivityStatisticRepo.findAllByUserIdAndDate(userId, date);
    }

    public Flux<UserActivityStatistic> findAllByUserIdAndDateBetween(Long userId, LocalDate startDate, LocalDate endDate) {
        return userActivityStatisticRepo.findAllByUserIdAndDateBetween(userId, startDate, endDate);
    }
}

