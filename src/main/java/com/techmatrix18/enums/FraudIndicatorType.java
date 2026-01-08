package com.techmatrix18.enums;

/**
 * Enumeration representing different types of fraud indicators.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 08.01.2026
 */
public enum FraudIndicatorType {
    HIGH_VALUE_TRANSACTION,
    RAPID_TRANSACTION_SEQUENCE,
    UNUSUAL_LOCATION,
    MULTIPLE_FAILED_ATTEMPTS,
    NEW_DEVICE_USAGE,
    BLACKLISTED_MERCHANT,
    SUSPICIOUS_IP_ADDRESS,
    ACCOUNT_TAKEOVER,
    CARD_NOT_PRESENT_TRANSACTION,
    OTHER
}

