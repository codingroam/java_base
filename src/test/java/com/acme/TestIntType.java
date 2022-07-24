package com.acme;

import org.junit.Assert;
import org.junit.Test;

public class TestIntType {

    @Test
    public void test(){
        int i = 1;
        Object o = i;
        System.out.println(o.getClass().toString());

    }
}
