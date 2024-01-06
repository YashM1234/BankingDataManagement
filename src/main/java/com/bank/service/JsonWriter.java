package com.bank.service;

import com.bank.model.BankTransaction;
import com.bank.model.LocationCount;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonWriter implements WriteOperation{
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void write(List<BankTransaction> transactions, String destination) {
        File file = new File(destination);
        String json = null;
        try {
            json = objectMapper.writeValueAsString(transactions);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException("Json not processed!");
        }

        try(FileWriter writer = new FileWriter(file)) {
            writer.write(json);
            writer.flush();
        }catch (IOException ex){
            throw new RuntimeException("File " + destination + " could not found!");
        }
    }

    public static void write(LocationCount metricsResult, String destination) {
        ObjectMapper objectMapper1 = new ObjectMapper();
        File file = new File(destination);
        String json = null;
        try {
            json = objectMapper1.writeValueAsString(metricsResult);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException("Json not processed!");
        }

        try(FileWriter writer = new FileWriter(file)) {
            writer.write(json);
            writer.flush();
        }catch (IOException ex){
            throw new RuntimeException("File " + destination + " could not found!");
        }
    }
}
