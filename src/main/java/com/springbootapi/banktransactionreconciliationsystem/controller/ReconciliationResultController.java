package com.springbootapi.banktransactionreconciliationsystem.controller;

import com.springbootapi.banktransactionreconciliationsystem.entity.ReconciliationResult;
import com.springbootapi.banktransactionreconciliationsystem.repository.ReconciliationResultRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reconciliation-results")
public class ReconciliationResultController {

    private final ReconciliationResultRepository repository;

    public ReconciliationResultController(ReconciliationResultRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ReconciliationResult> getAllResults() {
        return repository.findAll();
    }
}
