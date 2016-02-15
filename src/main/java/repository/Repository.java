package repository;

import java.util.List;

/**
 * Created by Andrei Kuzniatsou on 15.02.2016.
 */
public interface Repository<T> {

    List<T> findAll();
}
