package com.springbootapi.banktransactionreconciliationsystem.repository;

import com.springbootapi.banktransactionreconciliationsystem.entity.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankTransactionRepository
        extends JpaRepository<BankTransaction, Long> {

    List<BankTransaction> findByUploadBatchId(Long uploadBatchId);
}