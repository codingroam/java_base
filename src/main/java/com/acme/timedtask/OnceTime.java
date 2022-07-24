package com.acme.timedtask;

public class OnceTime extends Task{


    public OnceTime() {
        super(2, 0L);
    }

    @Override
    void execute() {
        System.out.println("一次性任务");
    }


}
