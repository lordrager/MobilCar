package com.example.mobilcar.Models.Abstact;

import java.util.Date;

public abstract class CarDocuments {
    private String name;
    private Date start_date;
    private Date end_date;
    private double price;
    public CarDocuments(String name, Date start_date, Date end_date, double price) {
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.price = price;
    }
    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
