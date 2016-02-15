package domain;

import util.GeneratingUtil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Andrei Kuzniatsou on 15.02.2016.
 */
public class PostService implements Runnable {

    private CyclicBarrier barrier;
    private Parcel parcel;

    public PostService(CyclicBarrier barrier, Parcel parcel) {
        this.barrier = barrier;
        this.parcel = parcel;
    }

    @Override
    public void run() {
        try {
            long delay1 = GeneratingUtil.getValueFromRange(1_000, 50_000);
            System.out.println("I have received the Parcel from: " + parcel.getFrom());
            System.out.println("I will spend " + delay1 + " milliseconds to process the parcel");
            Thread.sleep(delay1);
            System.out.println("I have processed the parcel and will send it to: " + parcel.getTo());
            barrier.await();
            System.out.println("I have sent the parcel to stage 2");
            long delay2 = GeneratingUtil.getValueFromRange(1_000, 50_000);
            System.out.println("Delivering takes  " + delay2 + " milliseconds");
            Thread.sleep(delay2);
            System.out.println("Parcel has been delivered");
            barrier.await();
            System.out.println("I have finished");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
