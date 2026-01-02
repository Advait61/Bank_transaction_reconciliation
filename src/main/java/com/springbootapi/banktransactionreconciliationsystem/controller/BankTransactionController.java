package com.springbootapi.banktransactionreconciliationsystem.controller;

import com.springbootapi.banktransactionreconciliationsystem.entity.BankTransaction;
import com.springbootapi.banktransactionreconciliationsystem.service.BankTransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank-transactions")
public class BankTransactionController {

    private final BankTransactionService service;

    public BankTransactionController(BankTransactionService service) {
        this.service = service;
    }

    @GetMapping
    public List<BankTransaction> getAll() {
        return service.getAllBankTransactions();
    }
}
