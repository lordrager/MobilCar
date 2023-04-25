package Models.Classes;

import Models.Abstact.Human;

public class Mechanic extends Human {
    private double price;
    private Service service_place;

    public Mechanic(int id, String first_name, String last_name, String egn, Location location, double price, Service service_place) {
        super(id, first_name, last_name, egn, location);
        this.price = price;
        this.service_place = service_place;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Service getService_place() {
        return service_place;
    }

    public void setService_place(Service service_place) {
        this.service_place = service_place;
    }
}
