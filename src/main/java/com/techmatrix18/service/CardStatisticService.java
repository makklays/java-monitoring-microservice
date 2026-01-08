package com.techmatrix18.service;

import com.techmatrix18.model.CardStatistic;
import com.techmatrix18.repository.CardStatisticRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

/**
 * Service for managing CardStatistic entities.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 08.01.2026
 */
@Service
public class CardStatisticService {
    private final CardStatisticRepository cardStatisticRepo;

    public CardStatisticService(CardStatisticRepository cardStatisticRepo) {
        this.cardStatisticRepo = cardStatisticRepo;
    }

    // Service methods for CardStatistic can be added here

    public Flux<CardStatistic> findAll() {
        return cardStatisticRepo.findAll();
    }

    public Flux<CardStatistic> findAllByDate(LocalDate date) {
        return cardStatisticRepo.findAllByDate(date);
    }

    public Flux<CardStatistic> findAllByDateBetween(LocalDate startDate, LocalDate endDate) {
        return cardStatisticRepo.findAllByDateBetween(startDate, endDate);
    }

    public Flux<CardStatistic> findAllByCardType(String cardType) {
        return cardStatisticRepo.findAllByCardType(cardType);
    }

    public Flux<CardStatistic> findAllByStatus(String status) {
        return cardStatisticRepo.findAllByStatus(status);
    }

    public Flux<CardStatistic> findAllByDateAndCardType(LocalDate date, String cardType) {
        return cardStatisticRepo.findAllByDateAndCardType(date, cardType);
    }

    public Flux<CardStatistic> findAllByDateAndCardTypeAndStatus(LocalDate date, String cardType, String status) {
        return cardStatisticRepo.findAllByDateAndCardTypeAndStatus(date, cardType, status);
    }
}

