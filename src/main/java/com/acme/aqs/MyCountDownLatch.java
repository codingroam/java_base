//package com.company.aqs;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MyCountDownLatch {
//    private volatile int count;
//    private List<Thread> objectList = new ArrayList<>();
//    public MyCountDownLatch(int count){
//        this.count = count;
//    }
//
//    public  void countDown(){
//
//        this.count--;
//        if(count == 0){
//            this.notifyAll();
//            objectList.forEach(u->{
//                u.notifyAll();
//            });
//
//        }
//    }
//
//    public void await() throws InterruptedException {
//
//
//        this.wait();
//        objectList.add(this);
//
//
//    }
//
//
//}
