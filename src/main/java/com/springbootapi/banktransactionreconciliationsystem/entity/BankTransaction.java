package com.springbootapi.banktransactionreconciliationsystem.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

//import com.bank.reconciliation.enums.TransactionType;


@Entity
@Table(name = "bank_transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String referenceId;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDate transactionDate;

    private String bankName;

    private Long uploadBatchId;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
