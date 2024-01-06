package com.bank.service;

import com.bank.helper.BankTransactionBuilder;
import com.bank.model.BankTransaction;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FileRead implements ReadOperation{
    @Override
    public List<BankTransaction> read(String source) {

        try(CSVReader reader = new CSVReader(new FileReader(source))){
            reader.readNext();
            List<String[]> data = reader.readAll();
            return convert(data);
        }catch(IOException ex){
//            throw new RuntimeException("File " + source + " not found!");
            ex.printStackTrace();
            return null;
        }
    }

    private List<BankTransaction> convert(List<String[]> data) {
        return data.stream().map(row -> {
                try {
                    return BankTransactionBuilder.build(row);
                }catch(Exception ex) {
                    System.err.println(ex.getMessage() + " while processing row:" + Arrays.toString(row));
                    return null;
                }
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }
}
