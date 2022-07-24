package com.acme.arthas;

import org.junit.Test;

import java.io.IOException;
import java.net.URLConnection;

public class Test1 {

    @Test
    public void test() throws IOException {

        URLConnection urlConnection = OpenUrlConnection.openURLConnection("https://tech.meituan.com/archives");
        String s = Utils.inputStreamToString(urlConnection.getInputStream());
        System.out.println("ddd");
    }
}
