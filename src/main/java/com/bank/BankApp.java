package com.bank;

import com.bank.model.BankTransaction;
import com.bank.service.*;

import java.util.List;

public class BankApp {
    public static void main(String[] args) {
        //split big  file
        FileOperation operation = new SplitFile();
        operation.split("src/main/resources/bankingData/bank_transactions.csv",50000, "src/main/resources/splitedFile/bankingData");

        //Read File
        ReadOperation reader = new FileRead();
        List<BankTransaction> bankTransactions = reader.read("src/main/resources/splitedFile/bankingData1.csv");

        //Json converter
        WriteOperation jsonWrite = new JsonWriter();
        jsonWrite.write(bankTransactions, "src/main/resources/jsonFile/bank_transactions.json");

        //metrics
        MetricsCollector genderCollector = new TransactionByGenderMetrics();
        genderCollector.collect(bankTransactions);

        MetricsCollector locationCollector = new TransactionByLocationMetrics();
        locationCollector.collect(bankTransactions);

        MetricsCollector locationWiseGenderCollector = new TransactionByLocationWiseGenderMetrics();
        locationWiseGenderCollector.collect(bankTransactions);

    }
}
