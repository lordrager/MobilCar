package com.example.mobilcar.Models.Classes;

public class Location {
    private int id;
    private String city_name;
    private String street;
    private int street_number;

    public Location(int id, String city_name, String street,int street_number) {
        this.id = id;
        this.city_name = city_name;
        this.street = street;
        this.street_number = street_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreet_number() {
        return street_number;
    }

    public void setStreet_number(int street_number) {
        this.street_number = street_number;
    }
}
