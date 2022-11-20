package com.acme.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;

public class SimpleClassLoaser extends ClassLoader{

    private String path;
    public SimpleClassLoaser(String path){
        this.path = path;
    }


    @Override
    protected Class<?> findClass(String name){
        String classPath = path + name.replace(".","//") + ".class";
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(classPath));
            int available = fileInputStream.available();
            byte[] classbyte = new byte[available];
            fileInputStream.read(classbyte);
            Class<?> aClass = defineClass(name, classbyte, 0, available);
            return aClass;

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public Class<?> loadClass(String name)  {
        Class<?> aClass = null;
        try{
            if(name.startsWith("java")){
                aClass = super.loadClass(name);
            }else{
                aClass = findClass(name);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return aClass;
    }

    public static void main(String[] args) throws Exception {
        String path = SimpleClassLoaser.class.getClassLoader().getResource("").getFile();
        SimpleClassLoaser simpleClassLoaser = new SimpleClassLoaser(path);
        Class<?> aClass = simpleClassLoaser.loadClass("com.example.classloader.TestLoadClass");
        Object instance = aClass.newInstance();
        Method echo = aClass.getMethod("echo", null);
        echo.invoke(instance);

    }




}
