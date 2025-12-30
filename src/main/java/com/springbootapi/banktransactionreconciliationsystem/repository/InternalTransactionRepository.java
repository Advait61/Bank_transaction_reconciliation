package com.springbootapi.banktransactionreconciliationsystem.repository;

import com.springbootapi.banktransactionreconciliationsystem.entity.InternalTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InternalTransactionRepository
        extends JpaRepository<InternalTransaction, Long> {

    Optional<InternalTransaction> findByReferenceId(String referenceId);
}