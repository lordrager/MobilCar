package com.example.mobilcar.Classes;

import com.example.mobilcar.Abstact.Human;


public class Owner extends Human {
    private Car car;
    private double budget;

    public Owner(int id, String first_name, String last_name, String username, String egn, String email, String password) {
        super(id, first_name, last_name, egn, email, username, password);

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
