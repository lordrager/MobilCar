package com.example.mobilcar.Classes;

import com.example.mobilcar.Abstact.CarDocuments;

import java.util.Date;


public class TechReview extends CarDocuments {

    //todo parametri

    public TechReview(int id, String name, Date start_date, Date end_date, Car car) {
        super(id, name, start_date, end_date, car);
    }
}
