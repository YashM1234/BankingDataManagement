package com.bank.service;

import com.bank.model.BankTransaction;

import java.util.List;

public interface WriteOperation {
    void write(List<BankTransaction> transactions, String destination);
}
