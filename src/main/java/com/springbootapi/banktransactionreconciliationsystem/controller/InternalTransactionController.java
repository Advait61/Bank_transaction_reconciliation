package com.springbootapi.banktransactionreconciliationsystem.controller;

import com.springbootapi.banktransactionreconciliationsystem.entity.InternalTransaction;
import com.springbootapi.banktransactionreconciliationsystem.service.InternalTransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/internal-transactions")
public class InternalTransactionController {

    private final InternalTransactionService service;

    public InternalTransactionController(InternalTransactionService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<InternalTransaction> create(
            @RequestBody InternalTransaction transaction) {

        InternalTransaction saved = service.createTransaction(transaction);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<InternalTransaction>> getAll() {
        return ResponseEntity.ok(service.getAllTransactions());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<InternalTransaction> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTransactionById(id));
    }
}
