package com.bank.service;

import com.bank.model.BankTransaction;

import java.util.List;

public interface ReadOperation {
    List<BankTransaction> read(String source);

}
