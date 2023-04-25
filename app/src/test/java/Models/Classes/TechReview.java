package Models.Classes;

import java.util.Date;

import Models.Abstact.CarDocuments;

public class TechReview extends CarDocuments {

    //todo parametri

    public TechReview(int id, String name, Date start_date, Date end_date, Car car) {
        super(id, name, start_date, end_date, car);
    }
}
