package com.example.mobilcar.Models.Classes;

import com.example.mobilcar.Models.Abstact.Human;

import java.util.Collections;
import java.util.List;


public class Owner extends Human {
    private List<Car> cars;

    public Owner(String name, String username, String email, String password, List<Car> cars ) {
        super(name, email, username, password);
        this.cars = cars;
    }

    public Owner(String name, String username, String email, String password) {
        super(name, email, username, password);
        cars =  Collections.<Car>emptyList();
    }

    public Owner() {
        super();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
