package com.acme.timedtask;

public abstract class Task implements Runnable{

    protected int taskType;

    //间隔
    protected Long interval;

    public Task(int taskType, Long interval) {
        this.taskType = taskType;
        this.interval = interval;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    abstract void execute();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        this.execute();
    }
}
