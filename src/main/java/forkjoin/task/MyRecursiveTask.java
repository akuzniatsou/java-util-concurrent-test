package forkjoin.task;

import java.util.concurrent.RecursiveTask;

/**
 * @author Andrei Kuzniatsou.
 */
public class MyRecursiveTask extends RecursiveTask<String> {

    @Override
    protected String compute() {
        String message = "Hello I'm task";
        System.out.println(message);
        return message;
    }
}
