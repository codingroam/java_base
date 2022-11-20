package com.acme.bytecode_enhance.asm;

import com.acme.bytecode_enhance.Base;
import org.junit.Test;

public class JunitTest {

    @Test
    public void test(){
        Base base = new Base();
        base.process();
    }
}
