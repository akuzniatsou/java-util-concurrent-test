package barrier;

import domain.Parcel;
import domain.PostService;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Andrei Kuzniatsou on 15.02.2016.
 */
public class CyclicBarrierExample {

    public static final int BARRIER_SIZE = 2;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CyclicBarrier barrier = new CyclicBarrier(BARRIER_SIZE);
        executor.execute(new PostService(barrier, new Parcel("User 1", "China", "Phone")));
        executor.execute(new PostService(barrier, new Parcel("User 2", "Malaysia", "PDA")));
        executor.shutdown();
    }
}
