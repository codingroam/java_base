package com.acme.timedtask;

import java.util.Date;

public class TimedTask extends Task{

    public TimedTask(Long interval) {
        super(1, interval);
    }

    @Override
    void execute() {
        System.out.println("定时任务间隔"+interval+new Date(System.currentTimeMillis()));
    }
}
