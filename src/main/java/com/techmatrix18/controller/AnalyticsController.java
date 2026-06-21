package com.techmatrix18.controller;

import com.techmatrix18.service.CardStatisticService;
import com.techmatrix18.service.MerchantStatisticService;
import com.techmatrix18.service.PaymentStatisticService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for analytics endpoints.
 *
 * TODO: Implement methods in class AnalyticsController.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 21.06.2026
 */
@RestController
@RequestMapping(path = "/api/v1/analytics", produces = "application/json")
@CrossOrigin(origins = "*")
public class AnalyticsController {
    private final CardStatisticService cardStatisticService;
    private final PaymentStatisticService paymentStatisticService;
    private final MerchantStatisticService merchantStatisticService;

    // Единый конструктор для внедрения всех сервисов аналитики
    public AnalyticsController(CardStatisticService cardStatisticService,
                               PaymentStatisticService paymentStatisticService,
                               MerchantStatisticService merchantStatisticService) {
        this.cardStatisticService = cardStatisticService;
        this.paymentStatisticService = paymentStatisticService;
        this.merchantStatisticService = merchantStatisticService;
    }

    @GetMapping(params = "kpis")
    public String getKPIs() {
        return "OK";
    }

    @GetMapping(params = "user-activity")
    public String getUserActivity() {
        return "OK";
    }
}

