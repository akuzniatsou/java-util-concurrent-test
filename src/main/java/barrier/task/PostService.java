package barrier.task;

import domain.Parcel;
import util.GeneratingUtil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Andrei Kuzniatsou on 15.02.2016.
 */
public class PostService implements Runnable {

    private Parcel parcel;
    private CyclicBarrier customBarrier;
    private CyclicBarrier userBarrier;

    public PostService(CyclicBarrier customBarrier, CyclicBarrier userBarrier, Parcel parcel) {
        this.customBarrier = customBarrier;
        this.userBarrier = userBarrier;
        this.parcel = parcel;
    }

    @Override
    public void run() {
        try {
            System.out.println("Post head office get the Parcel #" + parcel.getId()+" from:" + parcel.getFrom());
            Thread.sleep(GeneratingUtil.getValueFromRange(1_000, 20_000));
            System.out.println("Post head office processed the Parcel #" + parcel.getId()+" and sent it to custom service");
            customBarrier.await();
            System.out.println("Custom service verified that the Parcel #" + parcel.getId()+" contains:"+parcel.getDescription()+" and sent to local post office");
            Thread.sleep(GeneratingUtil.getValueFromRange(1_000, 20_000));
            System.out.println("Post head office get the Parcel #" + parcel.getId()+" from custom service and delivered to " + parcel.getTo());
            userBarrier.await();
            System.out.println("Parcel #" + parcel.getId()+" was successfully delivered");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
