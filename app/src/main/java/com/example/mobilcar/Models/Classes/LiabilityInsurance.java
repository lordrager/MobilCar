package com.example.mobilcar.Models.Classes;

import com.example.mobilcar.Models.Abstact.CarDocuments;

import java.util.Date;


public class LiabilityInsurance extends CarDocuments {

    public LiabilityInsurance(int id, String name, Date start_date, Date end_date, double price) {
        super(id, name, start_date, end_date, price);
    }
}
