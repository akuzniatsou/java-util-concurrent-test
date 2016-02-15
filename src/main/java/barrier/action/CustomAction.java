package barrier.action;

import domain.Parcel;
import util.GeneratingUtil;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Andrei Kuzniatsou on 15.02.2016.
 */
public class CustomAction implements Runnable {

    private List<Parcel> parcels;

    public CustomAction(List<Parcel> parcels) {
        this.parcels = parcels;
    }

    @Override
    public void run() {
        try {
            for (Parcel parcel : parcels) {
                System.out.println("Inspecting the Parcel #" + parcel.getId());
                Thread.sleep(GeneratingUtil.getValueFromRange(1_000, 5_000));
                System.out.println("I found out that Parcel #" + parcel.getId() + " contains:" + parcel.getDescription());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
