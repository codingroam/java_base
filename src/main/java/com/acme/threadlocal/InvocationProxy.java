package com.acme.threadlocal;

import java.util.HashMap;
import java.util.Map;

public class InvocationProxy {

    private static Map<Thread,ThreadLocal<Object>> map = new HashMap<>();

    public static void put(Object o){
        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
        objectThreadLocal.set(o);
        map.put(Thread.currentThread(),objectThreadLocal);
    }

    public static Object get(){
        return map.get(Thread.currentThread()).get();
    }
}
