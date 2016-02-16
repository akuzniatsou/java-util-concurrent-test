package barrier;

import barrier.task.SimplePostService;
import domain.Parcel;
import repository.ParcelRepository;
import repository.Repository;

import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Andrei Kuzniatsou on 15.02.2016.
 */
public class CyclicBarrierExample {

    private static Repository<Parcel> PARCEL_REPOSITORY = new ParcelRepository();

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        List<Parcel> parcels = PARCEL_REPOSITORY.findAll();
        CyclicBarrier barrier = new CyclicBarrier(parcels.size());

        for (Parcel parcel : parcels) {
            executor.execute(new SimplePostService(barrier, barrier, parcel));
        }
        executor.shutdown();
    }
}

