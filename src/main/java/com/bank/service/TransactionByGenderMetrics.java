package com.bank.service;

import com.bank.model.BankTransaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionByGenderMetrics implements MetricsCollector{

    @Override
    public void collect(List<BankTransaction> transactions){
        Map<Character, List<BankTransaction>> genderGroups = transactions.stream()
                .collect(Collectors.groupingBy(BankTransaction::getGender));

        System.out.println("Transactions done by Male: " + genderGroups.get('M').size());
        System.out.println("Transactions done by Female: " + genderGroups.get('F').size());

    }
}
