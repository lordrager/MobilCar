package com.example.mobilcar.Models.Classes;

import com.example.mobilcar.Models.Abstact.Human;


public class Owner extends Human {

    public Owner(String name, String username, String email, String password) {
        super(name, email, username, password);
    }

    public Owner() {
        super();
    }

}
