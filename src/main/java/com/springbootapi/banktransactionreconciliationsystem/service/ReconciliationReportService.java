package com.springbootapi.banktransactionreconciliationsystem.service;

import com.springbootapi.banktransactionreconciliationsystem.repository.ReconciliationResultRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReconciliationReportService {

    private final ReconciliationResultRepository repository;

    public ReconciliationReportService(ReconciliationResultRepository repository) {
        this.repository = repository;
    }

    public Map<String, Long> getSummary() {
        Map<String, Long> summary = new HashMap<>();

        for (Object[] row : repository.countByStatus()) {
            summary.put(row[0].toString(), (Long) row[1]);
        }

        return summary;
    }
}