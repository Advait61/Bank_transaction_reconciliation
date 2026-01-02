package com.springbootapi.banktransactionreconciliationsystem.controller;

import com.springbootapi.banktransactionreconciliationsystem.entity.BankTransaction;
import com.springbootapi.banktransactionreconciliationsystem.service.BankTransactionService;
import com.springbootapi.banktransactionreconciliationsystem.service.csv.BankCsvParserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/bank-transactions")
public class BankTransactionController {

    private final BankTransactionService bankTransactionService;
    private final BankCsvParserService csvParserService;

    public BankTransactionController(
            BankTransactionService bankTransactionService,
            BankCsvParserService csvParserService) {

        this.bankTransactionService = bankTransactionService;
        this.csvParserService = csvParserService;
    }

    // EXISTING API
    @GetMapping
    public List<BankTransaction> getAll() {
        return bankTransactionService.getAllBankTransactions();
    }

    // 🔥 STEP 3 CODE GOES HERE 🔥
    @PostMapping("/upload")
    public ResponseEntity<String> uploadBankCsv(
            @RequestParam("file") MultipartFile file) {

        csvParserService.parse(file)
                .forEach(bankTransactionService::saveBankTransaction);

        return ResponseEntity.ok("Bank CSV uploaded successfully");
    }
}
