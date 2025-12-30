package com.springbootapi.banktransactionreconciliationsystem.entity;

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
@Table(name = "reconciliation_run")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReconciliationRun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate runDate;

    private String initiatedBy;

    private String status;

    private Integer totalInternal;

    private Integer totalBank;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
