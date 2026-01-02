package com.springbootapi.banktransactionreconciliationsystem.service;

import com.springbootapi.banktransactionreconciliationsystem.entity.BankTransaction;
import com.springbootapi.banktransactionreconciliationsystem.entity.InternalTransaction;
import com.springbootapi.banktransactionreconciliationsystem.entity.ReconciliationResult;
import com.springbootapi.banktransactionreconciliationsystem.enums.ReconciliationStatus;
import com.springbootapi.banktransactionreconciliationsystem.repository.BankTransactionRepository;
import com.springbootapi.banktransactionreconciliationsystem.repository.InternalTransactionRepository;
import com.springbootapi.banktransactionreconciliationsystem.repository.ReconciliationResultRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReconciliationService {

    private final InternalTransactionRepository internalRepo;
    private final BankTransactionRepository bankRepo;
    private final ReconciliationResultRepository resultRepo;

    public ReconciliationService(
            InternalTransactionRepository internalRepo,
            BankTransactionRepository bankRepo,
            ReconciliationResultRepository resultRepo) {

        this.internalRepo = internalRepo;
        this.bankRepo = bankRepo;
        this.resultRepo = resultRepo;
    }

    @Transactional
    public void reconcile() {

        Map<String, BankTransaction> bankMap = bankRepo.findAll().stream()
                .collect(Collectors.toMap(
                        BankTransaction::getReferenceId,
                        b -> b,
                        (b1, b2) -> b1 // duplicate handling later
                ));

        for (InternalTransaction internal : internalRepo.findAll()) {

            BankTransaction bank = bankMap.get(internal.getReferenceId());

            ReconciliationResult result = getReconciliationResult(internal, bank);


            resultRepo.save(result);
        }
    }

    private static ReconciliationResult getReconciliationResult(InternalTransaction internal, BankTransaction bank) {
        ReconciliationResult result = new ReconciliationResult();
        result.setInternalTransaction(internal);
        result.setBankTransaction(bank);

        if (bank == null) {
            result.setReconciliationStatus(ReconciliationStatus.MISSING_IN_BANK);
            result.setRemarks("Not found in bank statement");

        } else if (internal.getAmount().compareTo(bank.getAmount()) == 0) {
            result.setReconciliationStatus(ReconciliationStatus.MATCHED);
            result.setRemarks("Amount matched");

        } else {
            result.setReconciliationStatus(ReconciliationStatus.AMOUNT_MISMATCH);
            result.setRemarks("Amount mismatch");
        }
        return result;
    }
}
