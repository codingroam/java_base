package com.acme.arthas;

import org.junit.Test;

import java.io.*;
import java.net.URLConnection;

public class FileOperator {

    @Test
    public void test() throws Exception {
        File tempFile = File.createTempFile("hihi", "hello");
        //File tempFile = new File("D:\\temp\\java_base\\海贼王.jpg");
        OutputStream outputStream = new FileOutputStream(tempFile);
        URLConnection urlConnection = OpenUrlConnection.openURLConnection("https://img0.baidu.com/it/u=1985874529,2483152613&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500");
        InputStream inputStream = urlConnection.getInputStream();
        byte[] bytes = new byte[1024*1024];
        int count = 0;
        while((count=(inputStream.read(bytes,0,1024*1024)))!=-1){
            outputStream.write(bytes,0,count);
        }
        Utils.unzip(tempFile.getAbsolutePath(),"D:\\temp\\java_base\\海贼王.jpg");
        System.out.println();
    }

}
