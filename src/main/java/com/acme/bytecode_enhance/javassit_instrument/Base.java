package com.acme.bytecode_enhance.javassit_instrument;

import javassist.ClassPool;
import javassist.CtClass;

import java.lang.management.ManagementFactory;

public class Base {
    private static String name;
    public static void main(String[] args) {
        name = ManagementFactory.getRuntimeMXBean().getName();
        String s = name.split("@")[0];
        ClassPool cp = ClassPool.getDefault();
        //CtClass cc = cp.get("com.acme.bytecode_enhance.javassit_instrument.Base");
        //打印当前Pid
        System.out.println("pid:"+s);
        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (Exception e) {
                break;
            }
            process();
        }
    }

    public static void process() {
        System.out.println("process");
    }
}