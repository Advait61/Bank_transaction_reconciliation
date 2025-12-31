
package com.springbootapi.banktransactionreconciliationsystem.service;

import com.springbootapi.banktransactionreconciliationsystem.entity.BankTransaction;

import java.util.List;

public interface BankTransactionService {

    BankTransaction saveBankTransaction(BankTransaction transaction);

    List<BankTransaction> getAllBankTransactions();
}
