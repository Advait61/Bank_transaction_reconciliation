package com.springbootapi.banktransactionreconciliationsystem.controller;

import com.springbootapi.banktransactionreconciliationsystem.service.ReconciliationReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/reconciliation/report")
public class ReconciliationReportController {

    private final ReconciliationReportService service;

    public ReconciliationReportController(ReconciliationReportService service) {
        this.service = service;
    }

    @GetMapping("/summary")
    public Map<String, Long> getSummary() {
        return service.getSummary();
    }
}
