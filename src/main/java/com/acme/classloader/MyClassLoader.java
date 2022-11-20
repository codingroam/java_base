package com.acme.classloader;

import com.company.Student;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.net.URL;

public class MyClassLoader extends ClassLoader{


    private static MyClassLoader c = new MyClassLoader();
    static {
         int i = 0;
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String path = MyClassLoader.class.getClassLoader().getResource("").getFile();
        path = path + name.replace(".","//")+".class";
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(path));
            int available = fileInputStream.available();
            byte[] bytes = new byte[available];
            fileInputStream.read(bytes);
            return defineClass(name,bytes,0,bytes.length);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;



    }

    public static void main(String[] args) throws Exception {
        System.out.println("uuuu");
        //Class<?> aClass1 = Class.forName("com.acme.Student");
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> aClass = myClassLoader.loadClass("com.company.Student");
        Student s = (Student)aClass.newInstance();
        Object o = aClass.newInstance();
        Method method = aClass.getMethod("say");
        method.invoke(o,null);



    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(name.startsWith("java.lang")){

            return super.loadClass(name);
        }
        return findClass(name);
    }
}
