package com.bank.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BankTransaction {
    private String transactionId;
    private String customerId;
    private Date customerDob;
    private char gender;
    private String location;
    private double amountBalance;
    private Date transactionDate;
    private long transactionTime;
    private double amountInr;
}
