package com.acme.proxy.cglibproxy;

import net.sf.cglib.proxy.*;
import org.junit.Test;

import java.lang.reflect.Method;

public class SampleClass {
    public String test(String input){
        return "hello world";
    }
    public int testInt(){
        return 1;
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
//        enhancer.setCallback(new MethodInterceptor() {
//            @Override
//            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//                System.out.println("before method run...");
//                Object result = proxy.invokeSuper(obj, args);
//                System.out.println("after method run...");
//                return result;
//            }
//        });

        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "FixedValue";
            }
        });

        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                return 0;
            }
        });

        SampleClass sample = (SampleClass) enhancer.create();
        System.out.println(sample.test(null));
        System.out.println(sample.testInt());
    }

    @Test
    public void testFixedValue(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "Hello cglib";
            }
        });
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println(proxy.test(null)); //拦截test，输出Hello cglib
        System.out.println(proxy.toString());
        System.out.println(proxy.getClass());
        System.out.println(proxy.hashCode());
    }
}