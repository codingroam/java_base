package com.acme.bytecode_enhance.javassist;


import com.acme.bytecode_enhance.Base;
import javassist.*;
import javassist.CtClass;

public class JavassistTest {
    public static void main(String[] args) throws Exception {
        Base base = new Base();
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.acme.bytecode_enhance.Base");
        CtMethod m = cc.getDeclaredMethod("process");
        m.insertBefore("{ System.out.println(\"start\"); }");
        m.insertAfter("{ System.out.println(\"end\"); }");
        Class c = cc.toClass();
        cc.writeFile("/Users/zen/projects");
        Base h = (Base)c.newInstance();
        h.process();
    }
}