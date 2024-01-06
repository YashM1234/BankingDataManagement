package com.bank.helper;

import com.bank.model.BankTransaction;
import org.apache.commons.lang3.StringUtils;

public class BankTransactionBuilder {
    public static BankTransaction build(String[] line) throws Exception {
        return BankTransaction.builder()
                .transactionId(StringUtils.isEmpty(line[0])? "nan" : line[0])
                .customerId(StringUtils.isEmpty(line[1])? "nan" : line[1])
                .customerDob(DateUtils.getData(StringUtils.isEmpty(line[2])? "nan" : line[2]))
                .gender(StringUtils.isEmpty(line[3]) ? 'N' : line[3].charAt(0))
                .location(StringUtils.isEmpty(line[4])? "nan" : line[4])
                .amountBalance(StringUtils.isEmpty(line[5]) ? 0 : Double.parseDouble(line[5]))
                .transactionDate(DateUtils.getData(StringUtils.isEmpty(line[6])? "nan" : line[6]))
                .transactionTime(StringUtils.isEmpty(line[7]) ? 0 : Long.parseLong(line[7]))
                .amountInr(StringUtils.isEmpty(line[8]) ? 0 : Double.parseDouble(line[8]))
                .build();
    }
}
