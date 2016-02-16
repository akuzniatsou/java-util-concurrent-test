package domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parcel parcel = (Parcel) o;
        return Objects.equals(id, parcel.id) &&
                Objects.equals(to, parcel.to) &&
                Objects.equals(from, parcel.from) &&
                Objects.equals(description, parcel.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, to, from, description);
    }
}
