package com.bank.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
@Data
@Builder
public class LocationCount {
    private Map<String, GenderCount> locationGenderTransaction;
}
