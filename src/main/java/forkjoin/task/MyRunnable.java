package forkjoin.task;

import util.GeneratingUtil;

/**
 * @author Andrei Kuzniatsou.
 */
public class MyRunnable implements Runnable {

    public static final long DELAY = GeneratingUtil.getValueFromRange(2_000, 2_000);

    @Override
    public void run() {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello I'm runnable");
    }
}
