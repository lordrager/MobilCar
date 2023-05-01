package com.example.mobilcar.Models.Classes;

import com.example.mobilcar.Models.Abstact.CarDocuments;

import java.util.Date;


public class TechReview extends CarDocuments {

    public TechReview(String name, Date start_date, Date end_date, double price) {
        super(name, start_date, end_date, price);
    }
}
