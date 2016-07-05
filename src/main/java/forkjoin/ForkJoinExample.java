package forkjoin;

import forkjoin.task.MyCallable;
import forkjoin.task.MyRecursiveAction;
import forkjoin.task.MyRecursiveTask;
import forkjoin.task.MyRunnable;

import java.util.concurrent.ForkJoinPool;

/**
 * @author Andrei Kuzniatsou.
 */
public class ForkJoinExample {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(1);

        // as an Executor Service
        forkJoinPool.execute(new MyRunnable());
        forkJoinPool.submit(new MyRunnable());

        // as an Executor Service
        forkJoinPool.submit(new MyCallable());

         forkJoinPool.invoke(new MyRecursiveAction());
         forkJoinPool.invoke(new MyRecursiveTask());
    }
}
