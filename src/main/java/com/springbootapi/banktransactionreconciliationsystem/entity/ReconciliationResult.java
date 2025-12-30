package com.springbootapi.banktransactionreconciliationsystem.entity;

import com.springbootapi.banktransactionreconciliationsystem.enums.ReconciliationStatus;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reconciliation_results")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReconciliationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "internal_transaction_id")
    private InternalTransaction internalTransaction;

    @ManyToOne
    @JoinColumn(name = "bank_transaction_id")
    private BankTransaction bankTransaction;

    @Enumerated(EnumType.STRING)
    private ReconciliationStatus reconciliationStatus;

    private String remarks;

    @ManyToOne
    @JoinColumn(name = "run_id")
    private ReconciliationRun run;

    @CreationTimestamp
    private LocalDateTime createdAt;
}

