package com.springbootapi.banktransactionreconciliationsystem.repository;

import com.springbootapi.banktransactionreconciliationsystem.entity.ReconciliationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReconciliationResultRepository
        extends JpaRepository<ReconciliationResult, Long> {
    @Query("""
        SELECT r.reconciliationStatus, COUNT(r)
        FROM ReconciliationResult r
        GROUP BY r.reconciliationStatus
    """)
    List<Object[]> countByStatus();
}
