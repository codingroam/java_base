package com.acme.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadFile {


    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\21036\\Desktop\\temp\\mysql-bin.000001"));
        byte[] bytes = new byte[2048];
        fileInputStream.read(bytes);
        System.out.println(new String(bytes,"utf16"));
    }
}
