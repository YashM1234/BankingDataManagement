package com.bank.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenderCount {
    private int total;
    private int male;
    private int female;
}
