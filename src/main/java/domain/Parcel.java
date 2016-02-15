package domain;

/**
 * Created by Andrei Kuzniatsou on 15.02.2016.
 */
public class Parcel {

    private int id;
    private String to;
    private String from;
    private String description;

    public Parcel(int id, String to, String from, String description) {
        this.id = id;
        this.to = to;
        this.from = from;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public String getDescription() {
        return description;
    }

}
