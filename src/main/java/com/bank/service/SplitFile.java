package com.bank.service;

import com.google.common.collect.Lists;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SplitFile implements FileOperation{

    @Override
    public void split(String source, int partitionCount, String destination) {
        try(CSVReader reader = new CSVReader(new FileReader(source))){
            List<String[]> data = reader.readAll();
            List<List<String[]>> partition = Lists.partition(data, partitionCount);
            int i = 1;
            for(List<String[]> subList : partition){
                CSVWriter writer = new CSVWriter(new FileWriter(destination + (i++) + ".csv"));
                writer.writeAll(subList);
            }

        }catch(IOException ex){
            throw new RuntimeException("File " + source + " not found!");
        }
    }
}
