package com.springbootapi.banktransactionreconciliationsystem.service.impl;

import com.springbootapi.banktransactionreconciliationsystem.entity.BankTransaction;
import com.springbootapi.banktransactionreconciliationsystem.repository.BankTransactionRepository;
import com.springbootapi.banktransactionreconciliationsystem.service.BankTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankTransactionServiceImpl implements BankTransactionService {

    private final BankTransactionRepository repository;

    public BankTransactionServiceImpl(BankTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public BankTransaction saveBankTransaction(BankTransaction transaction) {
        return repository.save(transaction);
    }

    @Override
    public List<BankTransaction> getAllBankTransactions() {
        return repository.findAll();
    }
}
