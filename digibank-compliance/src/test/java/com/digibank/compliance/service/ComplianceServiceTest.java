package com.digibank.compliance.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplianceServiceTest {

    private ComplianceService complianceService;

    @BeforeEach
    void setUp() {
        complianceService = new ComplianceService();
    }

    @Test
    void validateTransactionAmount_WhenAmountIsNull_ShouldReturnFalse() {
        assertFalse(complianceService.validateTransactionAmount(null));
    }

    @Test
    void validateTransactionAmount_WhenAmountIsZero_ShouldReturnTrue() {
        assertTrue(complianceService.validateTransactionAmount(0.0));
    }

    @Test
    void validateTransactionAmount_WhenAmountIsExactly10000_ShouldReturnTrue() {
        assertTrue(complianceService.validateTransactionAmount(10000.0));
    }

    @Test
    void validateTransactionAmount_WhenAmountIsLessThan10000_ShouldReturnTrue() {
        assertTrue(complianceService.validateTransactionAmount(5000.0));
    }

    @Test
    void validateTransactionAmount_WhenAmountIsGreaterThan10000_ShouldReturnFalse() {
        assertFalse(complianceService.validateTransactionAmount(15000.0));
    }

    @Test
    void validateTransactionAmount_WhenAmountIsNegative_ShouldReturnTrue() {
        assertTrue(complianceService.validateTransactionAmount(-100.0));
    }
}
