package barrier;

import barrier.action.CustomAction;
import barrier.action.UserAction;
import barrier.task.PostService;
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
public class CyclicBarrierWithActionExample {

    private static Repository<Parcel> PARCEL_REPOSITORY = new ParcelRepository();

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        List<Parcel> parcels = PARCEL_REPOSITORY.findAll();

        CyclicBarrier customBarrier = new CyclicBarrier(parcels.size(), new CustomAction(parcels));
        CyclicBarrier userBarrier = new CyclicBarrier(parcels.size(), new UserAction(parcels));

        for (Parcel parcel : parcels) {
            executor.execute(new PostService(customBarrier, userBarrier, parcel));
        }
        executor.shutdown();
    }
}
