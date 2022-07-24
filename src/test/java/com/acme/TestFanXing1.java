package com.acme;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestFanXing1<T> {
    Map<Class<T>,T> map = new HashMap<>();
    @Test
    public void test(){
        TestFanXing1<String> stringTestFanXing1 = new TestFanXing1<>();
        stringTestFanXing1.put(String.class,"6666");

    }

    public void put(Class<T> clazz,T instance){
        map.put(clazz,instance);
    }



}
