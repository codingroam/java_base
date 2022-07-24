package com.acme.classloader;

import java.io.File;
import java.net.URL;

public class GetContextClassLoader {

    public static void main(String[] args) {
        ClassLoader cL = Thread.currentThread().getContextClassLoader();
        URL resource = cL.getResource("1.txt");
        String fileName = resource.getFile();
        File file1 = new File(fileName);



    }
}
