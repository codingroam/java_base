package com.acme.bytecode_enhance.javassit_instrument.hotswap;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("请输入pid");
        Scanner scanner = new Scanner(System.in);
        String pidStr = scanner.next();
        //System.out.println("pid="+pidStr);
        System.out.println("请输入path");
        String pathStr = scanner.next();
        new FileHostSwap(pidStr,pathStr).start();
        //System.out.println("path="+pathStr);


    }
}
