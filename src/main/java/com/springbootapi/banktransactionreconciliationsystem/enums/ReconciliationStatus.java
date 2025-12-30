package com.springbootapi.banktransactionreconciliationsystem.enums;

public enum ReconciliationStatus {
    MATCHED,
    AMOUNT_MISMATCH,
    MISSING_IN_BANK,
    MISSING_IN_INTERNAL,
    DUPLICATE
}