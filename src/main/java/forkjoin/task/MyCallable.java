package forkjoin.task;

import java.util.concurrent.Callable;

/**
 * @author Andrei Kuzniatsou.
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        String message = "Hello I'm callable";
        System.out.println(message);
        return message;
    }
}
