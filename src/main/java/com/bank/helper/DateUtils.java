package com.bank.helper;

import com.bank.exception.InvalidDateException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils{
    public static Date getData(String stringDate) throws Exception{
        if(stringDate.isEmpty()||stringDate.matches("^[a-z A-Z]+$")){
            throw new InvalidDateException("Invalid date provided!");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        Date date = dateFormat.parse(stringDate);
        return date;
    }
}
