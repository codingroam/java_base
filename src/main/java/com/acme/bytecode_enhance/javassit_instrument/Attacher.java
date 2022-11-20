package com.acme.bytecode_enhance.javassit_instrument;

import com.sun.tools.attach.VirtualMachine;

public class Attacher {
    public static void main(String[] args) throws Exception {
        // 传入目标 JVM pid
        VirtualMachine vm = VirtualMachine.attach("18236");
        vm.loadAgent("C:\\Users\\Administrator\\Desktop\\ll\\operation-server.jar");
    }
}