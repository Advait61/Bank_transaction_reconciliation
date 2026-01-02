package com.springbootapi.banktransactionreconciliationsystem.repository;

import com.springbootapi.banktransactionreconciliationsystem.entity.ReconciliationResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReconciliationResultRepository
        extends JpaRepository<ReconciliationResult, Long> {
}
