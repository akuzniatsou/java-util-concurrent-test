package domain;

/**
 * Created by Andrei Kuzniatsou on 15.02.2016.
 */
public class Parcel {

    private String to;
    private String from;
    private String description;

    public Parcel(String to, String from, String description) {
        this.to = to;
        this.from = from;
        this.description = description;
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
