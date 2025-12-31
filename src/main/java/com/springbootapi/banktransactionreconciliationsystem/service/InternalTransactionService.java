package com.springbootapi.banktransactionreconciliationsystem.service;

import com.springbootapi.banktransactionreconciliationsystem.entity.InternalTransaction;

import java.util.List;

public interface InternalTransactionService {

    InternalTransaction createTransaction(InternalTransaction transaction);

    List<InternalTransaction> getAllTransactions();

    InternalTransaction getTransactionById(Long id);
}
