package com.bank.service;

public interface FileOperation {
    void split(String source, int partitionCount, String destination);
}
