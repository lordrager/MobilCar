package com.example.mobilcar.Models.Classes;

import com.example.mobilcar.Models.Abstact.Human;


public class Owner extends Human {
    private Car car;

    public Owner(String id, String name, String username, String email, String password, Car car ) {
        super(id,name, email, username, password);
        this.car = car;
    }

    public Owner(String id, String name, String username, String email, String password) {
        super(id,name, email, username, password);
    }

    public Owner() {
        super();
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


}
