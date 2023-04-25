package Models.Classes;

import java.util.List;

public class Service {
    private int id;
    private Location location;
    private String name;
    private List<Mechanic> mechanics;

    public Service(int id, Location location, String name, List<Mechanic> mechanics) {
        this.id = id;
        this.location = location;
        this.name = name;
        this.mechanics = mechanics;
    }
}
