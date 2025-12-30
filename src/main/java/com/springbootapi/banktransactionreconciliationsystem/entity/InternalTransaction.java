package com.springbootapi.banktransactionreconciliationsystem.entity;

//package com.springbootapi.banktransactionreconciliationsystem.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.springbootapi.banktransactionreconciliationsystem.enums.TransactionType;


@Entity
@Table(name = "internal_transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InternalTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference_id", nullable = false, unique = true)
    private String referenceId;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(name = "transaction_date", nullable = false)
    private LocalDate transactionDate;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Column(nullable = false)
    private String status = "PENDING";

    @CreationTimestamp
    private LocalDateTime createdAt;
}