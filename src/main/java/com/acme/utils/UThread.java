package com.acme.utils;

public class UThread {
    public static  void sleep(Long l){
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
