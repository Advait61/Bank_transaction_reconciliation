package com.springbootapi.banktransactionreconciliationsystem.service.impl;

import com.springbootapi.banktransactionreconciliationsystem.entity.InternalTransaction;
import com.springbootapi.banktransactionreconciliationsystem.repository.InternalTransactionRepository;
import com.springbootapi.banktransactionreconciliationsystem.service.InternalTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternalTransactionServiceImpl implements InternalTransactionService {

    private final InternalTransactionRepository repository;

    public InternalTransactionServiceImpl(InternalTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public InternalTransaction createTransaction(InternalTransaction transaction) {
        return repository.save(transaction);
    }

    @Override
    public List<InternalTransaction> getAllTransactions() {
        return repository.findAll();
    }

    @Override
    public InternalTransaction getTransactionById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id " + id));
    }
}
