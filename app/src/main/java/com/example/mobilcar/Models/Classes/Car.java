package com.example.mobilcar.Models.Classes;

public class Car {
    private String brand;
    private String model;
    private String gas_per_km;
    private String horse_power;

    private String year_made;

//    private TechReview techReview;
//    private LiabilityInsurance liabilityInsurance;
//    private String user_id;

//    public Car(String brand, String model, String gas_per_km, String horse_power, TechReview techReview, LiabilityInsurance liabilityInsurance) {
//        this.brand = brand;
//        this.model = model;
//        this.gas_per_km = gas_per_km;
//        this.horse_power = horse_power;
////        this.techReview = techReview;
////        this.liabilityInsurance = liabilityInsurance;
//    }

    public Car(String brand, String model, String gas_per_km, String horse_power, String year_made) {

        this.brand = brand;
        this.model = model;
        this.gas_per_km = gas_per_km;
        this.horse_power = horse_power;
        this.year_made = year_made;
    }

    public Car() {
        this.brand = "none";
        this.model = "none";
        this.gas_per_km = "none";
        this.horse_power = "none";
        this.year_made = "none";
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

    public String getGas_per_km() {
        return gas_per_km;
    }

    public void setGas_per_km(String gas_per_km) {
        this.gas_per_km = gas_per_km;
    }

    public String getHorse_power() {
        return horse_power;
    }

    public void setHorse_power(String horse_power) {
        this.horse_power = horse_power;
    }

    public String getYear_made() {
        return year_made;
    }

    public void setYear_made(String year_made) {
        this.year_made = year_made;
    }
//    public TechReview getTechReview() {
//        return techReview;
//    }
//
//    public void setTechReview(TechReview techReview) {
//        this.techReview = techReview;
//    }
//
//    public LiabilityInsurance getLiabilityInsurance() {
//        return liabilityInsurance;
//    }
//
//    public void setLiabilityInsurance(LiabilityInsurance liabilityInsurance) {
//        this.liabilityInsurance = liabilityInsurance;
//    }

//    public String getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(String user_id) {
//        this.user_id = user_id;
//    }

//    @NonNull
//    @Override
//    public String toString() {
//        return "Car{" +
//                ", brand='" + brand + '\'' +
//                ", model='" + model + '\'' +
//                ", year_made='" + year_made + '\'' +
//                ", gas_per_km='" + gas_per_km + '\'' +
//                ", horse_power='" + horse_power + '\'' +
//                ", techReview=" + techReview +
//                ", liabilityInsurance=" + liabilityInsurance +
//                '}';
//    }
}
