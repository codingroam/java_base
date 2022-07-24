package com.acme.generic;

import java.util.ArrayList;
import java.util.List;

public class RawType<T> {


    public static void main(String[] args) {
        List list = new ArrayList<String>();
        list.add(89);
        Object o = list.get(0);
        System.out.println();
       // List<Object> list2 = new ArrayList<String>();
//        List<?> list3 = new ArrayList<>();
//        list3.add("ppp");
    }

    public void method1(){
        T[] t = null;

    }


}
