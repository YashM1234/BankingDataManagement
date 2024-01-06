package com.bank.service;

import com.bank.model.BankTransaction;

import java.util.List;

public interface MetricsCollector {
    void collect(List<BankTransaction> transactions);
}
