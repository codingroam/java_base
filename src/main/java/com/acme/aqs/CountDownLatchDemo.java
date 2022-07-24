package com.acme.aqs;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {


    public static void main(String[] args){
        //MyCountDownLatch countDownLatch = new MyCountDownLatch(5);
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for(int i = 0; i < 5; i++){
            new Thread(()->{
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName+"准备！");
                countDownLatch.countDown();
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadName+"跑。。");

            }).start();
        }
    }
}
