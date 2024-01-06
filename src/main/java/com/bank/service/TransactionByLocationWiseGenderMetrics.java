package com.bank.service;

import com.bank.model.BankTransaction;
import com.bank.model.GenderCount;
import com.bank.model.LocationCount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionByLocationWiseGenderMetrics implements MetricsCollector{
    @Override
    public void collect(List<BankTransaction> transactions) {
        Map<String, GenderCount> countGender = new HashMap<>();

        Map<String, List<BankTransaction>> locationGroup = transactions.stream()
                .collect(Collectors.groupingBy(BankTransaction::getLocation));

        locationGroup.forEach((location, record) -> {
            Map<Character, List<BankTransaction>> genderGroup = record.stream()
                    .collect(Collectors.groupingBy(BankTransaction::getGender));

            GenderCount genderCount = GenderCount.builder().total(record.size()).build();
            genderGroup.entrySet().forEach((entry) -> {
                setValue(entry, genderCount);
            });
            countGender.put(location, genderCount);
        });
        LocationCount locationCount = LocationCount.builder().locationGenderTransaction(countGender).build();
        JsonWriter.write(locationCount, "src/main/resources/metrics/transactionByLocationWiseGenderData.json");
    }

    private void setValue(Map.Entry<Character, List<BankTransaction>> entry, GenderCount genderCount) {
        if('M' == entry.getKey()){
            genderCount.setMale(entry.getValue().size());
        }else if('F' == entry.getKey()){
            genderCount.setFemale(entry.getValue().size());
        }
    }
}
