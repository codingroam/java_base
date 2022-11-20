package com.acme.bytecode_enhance.asm;

import com.acme.bytecode_enhance.Base;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;


import java.io.File;
import java.io.FileOutputStream;

public class Generator {
    public static void main(String[] args) throws Exception {
		//读取
        ClassReader classReader = new ClassReader("com/acme/bytecode_enhance/asm/Base");
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        //处理
        ClassVisitor classVisitor = new MyClassVisitor(classWriter);
        classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
        byte[] data = classWriter.toByteArray();



        //输出
        String resourcePath= Generator.class.getResource("/").getPath();
        File f = new File(resourcePath+ "com/acme/bytecode_enhance/asm/Base.class");
        FileOutputStream fout = new FileOutputStream(f);
        fout.write(data);
        fout.close();
        Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass("com.acme.bytecode_enhance.Base");
        Base o = (Base)aClass.getDeclaredConstructor().newInstance();
        o.process();
        System.out.println("now generator cc success!!!!!");
    }
}