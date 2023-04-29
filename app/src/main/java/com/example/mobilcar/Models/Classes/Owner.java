package com.example.mobilcar.Models.Classes;

import com.example.mobilcar.Models.Abstact.Human;


public class Owner extends Human {
    private Car car;
    private double budget;

    public Owner(int id, String name, String username, String email, String password, double budget, Car car ) {
        super(id,name, email, username, password);
        this.budget = budget;
        this.car = car;
    }

    public Owner(int id, String name, String username, String email, String password, double budget) {
        super(id,name, email, username, password);
        this.budget = budget;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

}
