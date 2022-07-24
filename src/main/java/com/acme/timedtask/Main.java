package com.acme.timedtask;

import java.util.concurrent.*;

public class Main {


    public static void main(String[] args) throws Exception {
        TimedTask timedTask = new TimedTask(2L);
        TimedTask timedTask1 = new TimedTask(3L);
        OnceTime onceTime = new OnceTime();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4,
                0L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(),
                new MyThreadFactory());
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2,new MyThreadFactory());
       scheduledExecutorService.scheduleAtFixedRate(timedTask, 0L, timedTask.getInterval(), TimeUnit.SECONDS);
       scheduledExecutorService.scheduleAtFixedRate(timedTask1, 0L, timedTask1.getInterval(), TimeUnit.SECONDS);


        System.in.read();

    }
}
