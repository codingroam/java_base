package com.acme.threadlocal;

import com.acme.utils.UThread;

import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Order {

    private static ExecutorService executorService;
    static{
        executorService = Executors.newFixedThreadPool(10);
    }

    public static void makeOrder(){
      //  Object o = InvocationProxy.get();
        UThread.sleep(1000L);
        System.out.println("下了订单,线程"+Thread.currentThread().getName());
    }
    public  void AnsycMakeOrder() throws NoSuchMethodException {
        Method makeOrder = this.getClass().getMethod("makeOrder");
        executorService.submit(new CallableInvoke(this,makeOrder,new Object[]{}));
    }


}
