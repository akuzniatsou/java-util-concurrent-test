package barrier.task;

import domain.Parcel;
import util.GeneratingUtil;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Andrei Kuzniatsou on 15.02.2016.
 */
public class PostService implements Runnable {

    private Parcel parcel;
    private List<Parcel> storage;
    private CyclicBarrier customBarrier;
    private CyclicBarrier userBarrier;

    public PostService(CyclicBarrier customBarrier, CyclicBarrier userBarrier, Parcel parcel, List<Parcel> storage) {
        this.customBarrier = customBarrier;
        this.userBarrier = userBarrier;
        this.parcel = parcel;
        this.storage = storage;
    }

    public PostService(CyclicBarrier customBarrier, CyclicBarrier userBarrier, Parcel parcel) {
        this(customBarrier, userBarrier, parcel, Collections.<Parcel>emptyList());
    }

    @Override
    public void run() {
        try {
            System.out.println("Post head office get the Parcel #" + parcel.getId()+" from:" + parcel.getFrom());
            Thread.sleep(GeneratingUtil.getValueFromRange(1_000, 20_000));
            System.out.println("Post head office processed the Parcel #" + parcel.getId() + " and sent it to custom service");
            storage.add(parcel);
            System.out.println("Storage contains:" + storage.size() + " parcels");
            customBarrier.await();
            storage.remove(parcel);
            System.out.println("Storage contains:" + storage.size() + " parcels");
            System.out.println("Custom service verified that the Parcel #" + parcel.getId() + " contains:" + parcel.getDescription() + " and sent to local post office");
            Thread.sleep(GeneratingUtil.getValueFromRange(1_000, 20_000));
            System.out.println("Post head office get the Parcel #" + parcel.getId() + " from custom service and delivered to " + parcel.getTo());
            storage.add(parcel);
            System.out.println("Storage contains:" + storage.size() + " parcels");
            userBarrier.await();
            storage.remove(parcel);
            System.out.println("Storage contains:" + storage.size() + " parcels");
            System.out.println("Parcel #" + parcel.getId()+" was successfully delivered");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
