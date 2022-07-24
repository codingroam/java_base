package com.acme.weak_reference;

import com.acme.utils.UThread;
import jdk.nashorn.internal.ir.CallNode;

import java.lang.ref.WeakReference;

public class WeakReferenceDemo {


    /**
     * vm加-XX:+PrintGCDetails打印垃圾回收信息
     * @param args
     */
    public static void main(String[] args) {

        WeakReference<Apple> appleWeakReference = new WeakReference<>(new Apple("富士苹果"));
        WeakReference<Apple> appleWeakReference1 = new WeakReference<>(new Apple("香蕉苹果"));
        Apple apple = appleWeakReference.get();
        System.out.println(apple);
        System.out.println(appleWeakReference1.get());
        System.gc();
        UThread.sleep(1000L);
        System.out.println(appleWeakReference.get());
        System.out.println(appleWeakReference1.get());


    }
}
