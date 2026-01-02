package com.springbootapi.banktransactionreconciliationsystem.controller;

import com.springbootapi.banktransactionreconciliationsystem.service.ReconciliationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reconciliation")
public class ReconciliationController {

    private final ReconciliationService service;

    public ReconciliationController(ReconciliationService service) {
        this.service = service;
    }

    @PostMapping("/run")
    public ResponseEntity<String> run() {
        service.reconcile();
        return ResponseEntity.ok("Reconciliation completed");
    }
}