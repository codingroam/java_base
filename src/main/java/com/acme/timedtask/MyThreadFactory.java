package com.acme.timedtask;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
    private int num;
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("task-"+num++);
        return thread;
    }
}
