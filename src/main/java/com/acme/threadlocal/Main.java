package com.acme.threadlocal;

import com.acme.utils.UThread;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException {


//        for(int i=0;i<100;i++){
//            String name = UUID.randomUUID().toString();
//            new Thread(()->{
//                InvocationProxy.put(name);
//                Order.makeOrder();
//
//
//            }).start();
//        }
        Order order = new Order();
        for(int i=0;i<100;i++){
            UThread.sleep(50L);
            order.AnsycMakeOrder();
        }
    }
}
