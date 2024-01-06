package com.bank.service;

import com.bank.model.BankTransaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionByLocationMetrics implements MetricsCollector{
    @Override
    public void collect(List<BankTransaction> transactions) {
        Map<String, List<BankTransaction>> locationGroup = transactions.stream()
                .collect(Collectors.groupingBy(BankTransaction::getLocation));

        for(Map.Entry<String, List<BankTransaction>> location : locationGroup.entrySet()){
            System.out.println("Location: " + location.getKey());
            System.out.println("Total Transaction: " + location.getValue().size());
        }
    }
}
