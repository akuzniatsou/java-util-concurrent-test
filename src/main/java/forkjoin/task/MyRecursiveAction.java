package forkjoin.task;

import java.util.concurrent.RecursiveAction;

/**
 * @author Andrei Kuzniatsou.
 */
public class MyRecursiveAction extends RecursiveAction {

    @Override
    protected void compute() {
        System.out.println("Hello I'm action");
    }
}
