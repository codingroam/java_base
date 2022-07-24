package com.acme.weak_reference;

import com.acme.utils.UThread;
import com.sun.javafx.util.WeakReferenceQueue;
import jdk.nashorn.internal.ir.CallNode;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakReferenceQueueDemo {


    /**
     * vm加-XX:+PrintGCDetails打印垃圾回收信息
     * @param args
     */
    public static void main(String[] args) {

        ReferenceQueue<Apple> appleReferenceQueue = new ReferenceQueue<>();
        WeakReference<Apple> appleWeakReference = new WeakReference<>(new Apple("富士苹果"),appleReferenceQueue);
        WeakReference<Apple> appleWeakReference1 = new WeakReference<>(new Apple("香蕉苹果"),appleReferenceQueue);
        System.gc();
        UThread.sleep(1000L);
        Reference<? extends Apple> poll = null;
        while((poll = appleReferenceQueue.poll()) != null){
            Apple apple = poll.get();
            System.out.println(apple+"weakref"+poll+"进入弱引用队列");
        }
//        Apple apple = appleWeakReference.get();
//        System.out.println(apple);
//        System.out.println(appleWeakReference1.get());
//
//        System.out.println(appleWeakReference.get());
//        System.out.println(appleWeakReference1.get());


    }
}
