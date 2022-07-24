package com.acme.jvm;

public class MethodHandleTest {

    static class ClassA{
        public void println(String s){
            System.out.println(s);
        }
    }


    public static void main(String[] args) {
        ClassA classA = new ClassA();
        classA.println("dfdfd");
    }
}
