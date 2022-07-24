package com.acme;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestFanXing {
    Map map = null;
    @Test
    public void test(){
        List list = new ArrayList<>();
        list.add("555");
        list.add(66);
        putTypeInstance(String.class,"dsf");
        putTypeInstance(Integer.class,999);
        String instance = getInstance(String.class);
        Integer instance2 = getInstance(Integer.class);
        System.out.println();
    }


    public <T>void putTypeInstance(Class<T> clazz,T instance){
        if(map == null){
            map = new HashMap<Class<T>,T>();
        }
        map.put(clazz,instance);

    }

    public <T> T getInstance(Class<T> clazz){

        return (T)map.get(clazz);

    }
}
