package repository;

import domain.Parcel;

import java.util.Arrays;
import java.util.List;

/**
 * @author Andrei Kuzniatsou.
 */
public class ParcelRepository implements Repository<Parcel> {


    @Override
    public List<Parcel> findAll() {
        return Arrays.asList(
                new Parcel(1, "User 1", "China", "Phone"),
                new Parcel(2, "User 2", "Malaysia", "PDA"),
                new Parcel(3, "User 3", "Japan", "Photo"),
                new Parcel(4, "User 4", "USA", "Laptop"),
                new Parcel(5, "User 5", "Russia", "Matreshka"));
    }
}
