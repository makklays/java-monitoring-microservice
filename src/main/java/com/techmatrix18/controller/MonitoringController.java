package com.techmatrix18.controller;

import com.techmatrix18.model.CardStatistic;
import com.techmatrix18.model.MerchantStatistic;
import com.techmatrix18.model.PaymentStatistic;
import com.techmatrix18.service.CardStatisticService;
import com.techmatrix18.service.MerchantStatisticService;
import com.techmatrix18.service.PaymentStatisticService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Controller for monitoring endpoints.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 08.01.2026
 */
@RestController
@RequestMapping(path = "/api/v1/monitoring", produces = "application/json")
@CrossOrigin(origins = "*")
public class MonitoringController {
    private final CardStatisticService cardStatisticService;
    private final PaymentStatisticService paymentStatisticService;
    private final MerchantStatisticService merchantStatisticService;

    public MonitoringController(CardStatisticService cardStatisticService,
                                PaymentStatisticService paymentStatisticService,
                                MerchantStatisticService merchantStatisticService) {
        this.cardStatisticService = cardStatisticService;
        this.paymentStatisticService = paymentStatisticService;
        this.merchantStatisticService = merchantStatisticService;
    }

    @GetMapping(params = "recent-card-statistic")
    public Flux<CardStatistic> recentCardStatistic() {
        return cardStatisticService.findAll().take(12);
    }

    @GetMapping(params = "recent-payment-statistic")
    public Flux<PaymentStatistic> recentPaymentStatistic() {
        return paymentStatisticService.findAll().take(12);
    }

    @GetMapping(params = "recent-merchant-statistic")
    public Flux<MerchantStatistic> recentMerchantStatistic() {
        return merchantStatisticService.findAll().take(12);
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }

    @GetMapping("/status")
    public String status() {
        return "Service is running";
    }
}

