package com.acme.bytecode_enhance.javassit_instrument.hotswap;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import sun.plugin2.jvm.JVMLauncher;

import java.io.IOException;

public class FileHostSwap {

    private String pid;
    private String path;

    public FileHostSwap(String pid, String path) {
        this.pid = pid;
        this.path = path;
    }


    public void start() {
        VirtualMachine virtualMachine = null;
        try {
            virtualMachine = VirtualMachine.attach(pid);
            virtualMachine.loadAgent("C:\\Users\\Administrator\\Desktop\\ll\\operation-server.jar");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (null != virtualMachine) {
                //attach 完成后需要通知结束
                try {
                    virtualMachine.detach();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
