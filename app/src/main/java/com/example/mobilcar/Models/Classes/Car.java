package com.example.mobilcar.Models.Classes;

public class Car {
    private String id;
    private String brand;
    private String model;
    private short year_made;
    private double gas_per_km;
    private int horse_power;
    private TechReview techReview;
    private LiabilityInsurance liabilityInsurance;

    public Car(String id, String brand, String model, short year_made, double gas_per_km, int horse_power, TechReview techReview, LiabilityInsurance liabilityInsurance) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year_made = year_made;
        this.gas_per_km = gas_per_km;
        this.horse_power = horse_power;
        this.techReview = techReview;
        this.liabilityInsurance = liabilityInsurance;
    }

    public Car(String id, String brand, String model, double gas_per_km, int horse_power) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.gas_per_km = gas_per_km;
        this.horse_power = horse_power;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public short getYear_made() {
        return year_made;
    }

    public void setYear_made(short year_made) {
        this.year_made = year_made;
    }

    public double getGas_per_km() {
        return gas_per_km;
    }

    public void setGas_per_km(double gas_per_km) {
        this.gas_per_km = gas_per_km;
    }

    public int getHorse_power() {
        return horse_power;
    }

    public void setHorse_power(int horse_power) {
        this.horse_power = horse_power;
    }

    public TechReview getTechReview() {
        return techReview;
    }

    public void setTechReview(TechReview techReview) {
        this.techReview = techReview;
    }

    public LiabilityInsurance getLiabilityInsurance() {
        return liabilityInsurance;
    }

    public void setLiabilityInsurance(LiabilityInsurance liabilityInsurance) {
        this.liabilityInsurance = liabilityInsurance;
    }
}
