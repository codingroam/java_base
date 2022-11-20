package com.acme.proxy.javaproxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


@Slf4j
public class OrderProxyHandler implements InvocationHandler {
    private Order order;

    public OrderProxyHandler(Order order){
        this.order = order;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        startLog();
        method.invoke(this.order,args);
        endLog();
        return null;
    }


    private void startLog(){
        log.info("下单开始前log...");
    }

    private void endLog(){
        log.info("下单结束后log...");

    }
}
