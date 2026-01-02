package com.springbootapi.banktransactionreconciliationsystem.service.csv;

import com.springbootapi.banktransactionreconciliationsystem.entity.BankTransaction;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankCsvParserService {

    public List<BankTransaction> parse(MultipartFile file) {
        try {
            CSVParser parser = CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .parse(new InputStreamReader(file.getInputStream()));


            List<BankTransaction> transactions = new ArrayList<>();

            for (CSVRecord record : parser) {
                BankTransaction tx = new BankTransaction();
                tx.setReferenceId(record.get("referenceId"));
                tx.setAmount(new BigDecimal(record.get("amount")));
                tx.setTransactionDate(LocalDate.parse(record.get("transactionDate")));
                tx.setBankName(record.get("bankName"));

                transactions.add(tx);
            }

            return transactions;

        } catch (Exception e) {
            throw new RuntimeException("Failed to parse CSV file", e);
        }
    }
}
