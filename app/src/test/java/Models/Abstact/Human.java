package Models.Abstact;

import Models.Classes.Location;

public abstract class Human {
    private int id;
    private String first_name;
    private String last_name;
    private String egn;
    private Location location;
    private String email;
    private String username;
    private double password;

    public Human(int id, String first_name, String last_name, String egn, String email, String username, double password) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.egn = egn;
//        this.location = location;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getPassword() {
        return password;
    }

    public void setPassword(double password) {
        this.password = password;
    }
}
