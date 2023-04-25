package Models.Classes;

import java.util.Date;

import Models.Abstact.CarDocuments;

public class TechReview extends CarDocuments {
    private Service service;

    public TechReview(Service service, int id, String name, Date start_date, Date end_date, Car car) {
        super(id, name, start_date, end_date, car);
        this.service = service;
    }
    public Service getService() {
        return service;
    }
    public void setService(Service service) {
        this.service = service;
    }
}
