package com.acme.concurrent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class ConcurrentModify {

    private static volatile Map<String,String> map = new ConcurrentHashMap<>();

    static{
        for(int i=0;i<40;i++){
            map.put(i+"", ThreadLocalRandom.current().toString());
        }
    }

    public static void main(String[] args) {



        map.forEach((k,v)->{
            new Thread(()->{
                map.remove("1");
            }).start();
            System.out.println("key"+k+"---"+"value"+v);

           // map.put("kk","vv");
        });




    }

}
