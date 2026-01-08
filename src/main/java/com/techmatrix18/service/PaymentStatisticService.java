package com.techmatrix18.service;

import com.techmatrix18.model.CardStatistic;
import com.techmatrix18.model.PaymentStatistic;
import com.techmatrix18.repository.PaymentStatisticRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

/**
 * Service for managing PaymentStatistic entities.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 08.01.2026
 */
@Service
public class PaymentStatisticService {
    private final PaymentStatisticRepository paymentStatisticRepo;

    public PaymentStatisticService(PaymentStatisticRepository paymentStatisticRepo) {
        this.paymentStatisticRepo = paymentStatisticRepo;
    }

    // Service methods for PaymentStatistic can be added here

    public Flux<PaymentStatistic> findAll() {
        return paymentStatisticRepo.findAll();
    }

    public Flux<PaymentStatistic> findAllByDate(LocalDate date) {
        return paymentStatisticRepo.findAllByDate(date);
    }

    public Flux<PaymentStatistic> findAllByDateBetween(LocalDate startDate, LocalDate endDate) {
        return paymentStatisticRepo.findAllByDateBetween(startDate, endDate);
    }

    public Flux<PaymentStatistic> findAllByPaymentType(String paymentType) {
        return paymentStatisticRepo.findAllByPaymentType(paymentType);
    }

    public Flux<PaymentStatistic> findAllByStatus(String status) {
        return paymentStatisticRepo.findAllByStatus(status);
    }

    public Flux<PaymentStatistic> findAllByCurrencyCode(String currencyCode) {
        return paymentStatisticRepo.findAllByCurrencyCode(currencyCode);
    }

    public Flux<PaymentStatistic> findAllByDateAndPaymentType(LocalDate date, String paymentType) {
        return paymentStatisticRepo.findAllByDateAndPaymentType(date, paymentType);
    }

    public Flux<PaymentStatistic> findAllByDateAndPaymentTypeAndStatus(LocalDate date, String paymentType, String status) {
        return paymentStatisticRepo.findAllByDateAndPaymentTypeAndStatus(date, paymentType, status);
    }
}

