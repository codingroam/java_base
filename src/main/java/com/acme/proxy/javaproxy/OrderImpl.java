package com.acme.proxy.javaproxy;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderImpl implements Order{


    @Override
    public void takeOrder(){
        log.info("用户下单....");

    }
}
